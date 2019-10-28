import React, { useState } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { connect } from 'react-redux';

import { sidebar, pointer, expanded, current } from './Sidebar.module.sass';

const navigation_routes = [
  { to: 'login', text: 'Login' },
  { to: 'register', text: 'Sign up' }
];

const authorised_routes = [
  { to: 'resource', text: 'Resource' },
  { to: 'project', text: 'Project' },
  { to: 'formula', text: 'Formula' }
];

export function Sidebar({ user, location: { pathname } }) {
  const [hasExpanded, setHasExpanded] = useState(false);

  const routes = user ? authorised_routes : navigation_routes;

  return (
    <nav className={hasExpanded ? `${expanded} ${sidebar}` : sidebar}>
      <ul>
        {routes.map(({ to, text }) => (
          <li key={to}>
            <Link className={pathname.includes(to) ? current : ''} to={to}>
              {text}
            </Link>
          </li>
        ))}
      </ul>
      <button onClick={() => setHasExpanded(!hasExpanded)} className={pointer}>
        {hasExpanded ? '<' : '>'}
      </button>
    </nav>
  );
}

const mapStateToProps = ({ user }) => ({ user });

const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(withRouter(Sidebar));
