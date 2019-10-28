import axios from 'axios';
import { ActionTypes } from '../redux/actions';

const apiUrl = process.env.REACT_APP_APIURL;
let [token, user] = [null, null];

export const refreshToken = store => next => action => {
  switch (action.type) {
    case ActionTypes.INIT:
    case ActionTypes.LOGIN:
    case ActionTypes.REGISTER:
      if (action.token) {
        token = action.token;
      }
      if (action.user) {
        user = action.user;
      }
      break;
    case ActionTypes.LOGOUT:
    case ActionTypes.ERROR:
      token = null;
      user = null;
      break;
    default:
  }
  return next(action);
};

const validate = () => {
  if (!token) {
    throw new Error('No token for backend api');
  }
};

const getConfig = () => ({
  headers: { Authorization: 'Bearer ' + token }
});

export const loadResources = async () => {
  validate();

  const { data } = await axios.get(`${apiUrl}/resource`, getConfig());
  return data;
};

export const updateResource = async resource => {
  validate();

  const { data } = await axios.post(
    `${apiUrl}/resource`,
    resource,
    getConfig()
  );
  return data;
};

export const updateResources = async resources => {
  validate();

  const { data } = await axios.post(
    `${apiUrl}/resource/batch`,
    resources,
    getConfig()
  );
  return data;
};

export const getProjectIds = async () => {
  validate();

  const { data } = await axios.get(
    `${apiUrl}/project/getProjectIds`,
    getConfig()
  );
  return data;
};

export const loadProjectsById = async id => {
  const { data } = await axios.get(
    `${apiUrl}/project/projectId/${id}`,
    getConfig()
  );
  return data;
};

export const batchDeleteProjects = async projects => {
  await axios.post(`${apiUrl}/project/delete/batch`, projects, getConfig());
};

export const batchUpdateProjects = async projects => {
  const { data } = await axios.post(
    `${apiUrl}/project/batch`,
    projects,
    getConfig()
  );
  return data;
};

export const getFormulaByProjectId = async id => {
  const { data } = await axios.get(
    `${apiUrl}/formula/projectId/${id}`,
    getConfig()
  );
  return data;
};

export const updateFormula = async formula => {
  const { data } = await axios.post(`${apiUrl}/formula`, formula, getConfig());
  return data;
};

const api = {
  refreshToken,
  loadResources,
  updateResource,
  updateResources,
  getProjectIds,
  loadProjectsById,
  batchDeleteProjects,
  batchUpdateProjects,
  getFormulaByProjectId,
  updateFormula,
  user
};

export default api;
