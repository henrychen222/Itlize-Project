import React, { useState, useReducer } from 'react';
import { Link, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';

import { form, button, checkbox, checkmark, bot } from './Login.module.sass';
import { Input, Validators } from '../../utils/Input/Input';
import { reducer, actions } from '../../utils/Input/reducers';
import { login, loginTemp, clearError } from '../../utils/redux/actions';

const initial_state = {
  username: {
    value: '',
    touched: false,
    valid: false
  },
  password: {
    value: '',
    touched: false,
    valid: false
  }
};

export function Login(props) {
  const [state, dispatch] = useReducer(reducer, initial_state);
  const [submitted, setSubmitted] = useState(false);
  const [remember, setRemember] = useState(true);

  if (props.user) {
    return <Redirect to="resource" />;
  }

  if (props.error && props.error.login) {
    alert(props.error.login);
    props.dispatch(clearError());
  }

  const onSubmit = event => {
    setSubmitted(true);
    event.preventDefault();

    const user = {
      username: state.username.value,
      password: state.password.value
    };

    if (remember) {
      props.dispatch(login(user));
    } else {
      props.dispatch(loginTemp(user));
    }
  };

  return (
    <div className={form}>
      <h1>Login</h1>

      <form onSubmit={onSubmit}>
        <Input
          type="text"
          required
          label="Username"
          value={state.username.value}
          validators={[Validators.required('username')]}
          could_validate={submitted || state.username.touched}
          onChange={event => {
            dispatch({
              field: 'username',
              type: actions.update,
              payload: event.target.value
            });
          }}
          set_valid={status =>
            dispatch({
              field: 'username',
              type: actions.valid,
              payload: status
            })
          }
        />

        <Input
          type="password"
          required
          label="Password"
          value={state.password.value}
          validators={[Validators.required('password')]}
          could_validate={submitted || state.password.touched}
          onChange={event => {
            dispatch({
              field: 'password',
              type: actions.update,
              payload: event.target.value
            });
          }}
          set_valid={status =>
            dispatch({
              field: 'password',
              type: actions.valid,
              payload: status
            })
          }
        />

        <div className={button}>
          <button type="submit">Login</button>
        </div>

        <label className={checkbox}>
          Remember me
          <input
            type="checkbox"
            checked={remember}
            onChange={() => setRemember(!remember)}
          />
          <span className={checkmark} />
        </label>
      </form>

      <div className={bot}>
        <Link to="register">sign up</Link>
        Forgot password?
      </div>
    </div>
  );
}

const mapStateToProps = ({ user, error }) => ({ user, error });

export default connect(mapStateToProps)(Login);
