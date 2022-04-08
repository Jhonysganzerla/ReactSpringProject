import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import * as apiCalls from './api/apiCalls';
import UserSignupPage from './pages/User/UserSignupPage';
const actions = {
  postSignup: apiCalls.postSignup
}

ReactDOM.render(
  <React.StrictMode>
    <UserSignupPage actions={actions} />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
