import React from 'react';
import PropTypes from 'prop-types';

import { wrapper } from './Input.module.sass';

export function Input({
  label,
  value,
  validators = [],
  could_validate = false,
  set_valid,
  ...rest
}) {
  let error_message = null;

  if (could_validate) {
    const errors = validators.map(fn => fn(value)).filter(Boolean);
    if (errors.length) {
      error_message = errors[0];
      set_valid(false);
    } else {
      set_valid(true);
    }
  }

  return (
    <label className={wrapper}>
      {label}
      <input value={value} {...rest} />
      <p> {error_message} </p>
    </label>
  );
}

const validatorBuilder = validator => (...args) => value =>
  validator(value, ...args);

const required = (value, part) => (value ? null : `${part} is required`);

export const Validators = {
  required: validatorBuilder(required)
};

Input.propTypes = {
  label: PropTypes.string,
  value: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
  validators: PropTypes.arrayOf(PropTypes.func),
  could_validate: PropTypes.bool,
  set_valid: PropTypes.func
};
