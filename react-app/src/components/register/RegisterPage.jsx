import { Fragment, useState } from 'react';
import { register } from '../../services/BondServices';

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

    const response = await register({
      email: formData.email,
      password: formData.password,
    });
    console.log(response);

    setFormData({
      email: '',
      password: '',
    });
  };

  return (
    <Fragment>
      <div>This is the register page</div>
      <form onSubmit={handleFormSubmit}>
        <div>
          <label>
            Email:
            <input
              type='text'
              name='email'
              value={formData.email}
              onChange={handleChange}
            />
          </label>
        </div>

        <div>
          <label>
            Password:
            <input
              type='password'
              name='password'
              value={formData.password}
              onChange={handleChange}
            />
          </label>
        </div>

        <button type='submit'>Submit</button>
      </form>
    </Fragment>
  );
};

export default RegisterPage;
