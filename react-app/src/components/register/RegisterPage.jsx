import { Fragment, useState } from 'react';
import { register } from '../../services/BondServices';

import './RegisterPage.css';

const RegisterPage = () => {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleFormSubmit = async (e) => {
    e.preventDefault();

    console.log('Submitting the form...');
    console.log('Form Data:', formData);

    const response = await register(formData);
    console.log(response);

    setFormData({
      email: '',
      password: '',
    });
  };

  return (
    <Fragment>
      <div className='register-page-container d-flex justify-content-center align-items-center flex-column text-center'>
        <h2 className='mb-4 fw-bold fs-1'>Register</h2>
        <form onSubmit={handleFormSubmit}>
          <div className='register-inputs-container d-flex justify-content-between flex-column align-items-center'>
            <div className='register-input-container d-flex justify-content-between align-items-center mb-4'>
              <label className='fst-italic fs-5'>Email:</label>
              <input
                type='text'
                name='email'
                value={formData.email}
                onChange={handleChange}
                className='register-input-elem'
              />
            </div>

            <div className='register-input-container d-flex justify-content-between align-items-center'>
              <label className='fst-italic fs-5'>Password:</label>
              <input
                type='password'
                name='password'
                value={formData.password}
                onChange={handleChange}
                className='register-input-elem'
              />
            </div>
          </div>

          <button type='submit' className='sign-up-btn mt-4'>
            Sign Up!
          </button>
        </form>
      </div>
    </Fragment>
  );
};

export default RegisterPage;
