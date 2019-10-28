import React, { useReducer, useState } from 'react';
import { Link, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';

import { form, button, bot } from './Register.module.sass';
import { reducer, actions } from '../../utils/Input/reducers';
import { Input, Validators } from '../../utils/Input/Input';
import { register, clearError } from '../../utils/redux/actions';

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
  },
  confirm: {
    value: '',
    touched: false,
    valid: false
  }
};

export function Register(props) {
  const [state, dispatch] = useReducer(reducer, initial_state);
  const [submitted, setSubmitted] = useState(false);

  if (props.user) {
    return <Redirect to="resource" />;
  }

  if (props.error && props.error.register) {
    alert(props.error.register);
    props.dispatch(clearError());
  }

  const validate_confirm_password = value =>
    value !== state.password.value ? 'passwords not match' : null;

  const onSubmit = event => {
    setSubmitted(true);
    event.preventDefault();
    const user = {
      username: state.username.value,
      password: state.password.value
    };
    props.dispatch(register(user));
  };

  return (
    <div className={form}>
      <h1>Register</h1>

      <form onSubmit={onSubmit}>
        <Input
          label="Username"
          type="text"
          required
          value={state.username.value}
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
          validators={[Validators.required('username')]}
          could_validate={submitted || state.username.touched}
        />

        <Input
          label="Password"
          type="password"
          required
          value={state.password.value}
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
          validators={[Validators.required('password')]}
          could_validate={submitted || state.password.touched}
        />

        <Input
          label="Confirm password"
          type="password"
          required
          value={state.confirm.value}
          onChange={event => {
            dispatch({
              field: 'confirm',
              type: actions.update,
              payload: event.target.value
            });
          }}
          set_valid={status =>
            dispatch({
              field: 'confirm',
              type: actions.valid,
              payload: status
            })
          }
          validators={[
            Validators.required('confirm'),
            validate_confirm_password
          ]}
          could_validate={submitted || state.confirm.touched}
        />

        <div className={button}>
          <button
            disabled={Object.values(state).some(row => !row.valid)}
            type="submit"
          >
            Register
          </button>
        </div>
      </form>

      <div className={bot}>
        <Link to="login">Login</Link>
        Already got account?
      </div>
    </div>
  );
}

const mapStateToProps = ({ user, error }) => ({ user, error });

export default connect(mapStateToProps)(Register);
