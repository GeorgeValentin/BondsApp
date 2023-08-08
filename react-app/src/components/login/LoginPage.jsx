import { Fragment, useState } from 'react';

import { login } from '../../services/BondServices';
import './LoginPage.css';
import { useNavigate } from 'react-router-dom';

const LoginPage = () => {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleFormSubmit = async (e) => {
    e.preventDefault();

    const response = await login(formData);

    if (response.status === 200) {
      localStorage.setItem('userId', response.data.userId);
      localStorage.setItem('userEmail', response.data.userEmail);
      localStorage.setItem('loggedInStatus', true);

      navigate('/bondsAtMaturity');
    }
    console.log(response);

    setFormData({
      email: '',
      password: '',
    });
  };

  return (
    <Fragment>
      <div className='login-page-container d-flex justify-content-center align-items-center flex-column text-center'>
        <h2 className='mb-4 fw-bold fs-1'>Login</h2>
        <form onSubmit={handleFormSubmit}>
          <div className='login-inputs-container d-flex justify-content-between flex-column align-items-center'>
            <div className='login-input-container d-flex justify-content-between align-items-center mb-4'>
              <label className='fst-italic fs-5'>Email:</label>
              <input
                className='login-input-elem'
                type='text'
                name='email'
                value={formData.email}
                onChange={handleChange}
              />
            </div>

            <div className='login-input-container d-flex justify-content-between align-items-center mb-4'>
              <label className='fst-italic fs-5'>Password:</label>
              <input
                className='login-input-elem'
                type='password'
                name='password'
                value={formData.password}
                onChange={handleChange}
              />
            </div>
          </div>

          <button type='submit' className='log-in-btn'>
            Log In
          </button>
        </form>
      </div>
    </Fragment>
  );
};

export default LoginPage;
