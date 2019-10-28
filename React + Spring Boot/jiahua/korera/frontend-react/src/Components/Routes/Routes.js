import React from 'react';
import { Switch, Route, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';

import Login from '../../Components/Login/Login';
import Register from '../../Components/Register/Register';
import { Resource } from '../../Components/Resource/Resource';
import { Project } from '../../Components/Project/Project';
import { Formula } from '../../Components/Formula/Formula';
import { Template } from '../../Components/Formula/Template';

const navigation_routes = [
  { path: '/login', component: Login },
  { path: '/register', component: Register }
];

const authorised_routes = [
  { path: '/resource', component: Resource },
  { path: '/project', component: Project },
  { path: '/formula', component: Formula },
  { path: '/template', component: Template }
];

export function Routes(props) {
  const { user } = props;

  let routes = navigation_routes;
  if (user) {
    routes = [...routes, ...authorised_routes];
  }

  return (
    <Switch>
      {routes.map(({ path, component }) => (
        <Route key={path} path={path} component={component} />
      ))}
      <Redirect to="/login" />
    </Switch>
  );
}

const mapStateToProps = ({ user }) => ({ user });

const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Routes);
