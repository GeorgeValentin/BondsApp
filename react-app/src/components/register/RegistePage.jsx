import { Fragment, useState } from 'react';

const RegisterPage = () => {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleFormSubmit = (e) => {
    e.preventDefault();

    console.log('Submitting the form...');
    console.log('Form Data:', formData);

    setFormData({
      name: '',
      email: '',
      message: '',
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
