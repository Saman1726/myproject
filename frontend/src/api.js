import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

export const register = (user) => {
  return axios.post(`${API_URL}/auth/register`, user);
};

export const login = (credentials) => {
  return axios.post(`${API_URL}/auth/login`, credentials);
};

export const getTransactions = (token) => {
  return axios.get(`${API_URL}/transactions`, {
    headers: { Authorization: `Bearer ${token}` },
  });
};

export const addTransaction = (transaction, token) => {
  return axios.post(`${API_URL}/transactions`, transaction, {
    headers: { Authorization: `Bearer ${token}` },
  });
};

export const getCategories = (token) => {
  return axios.get(`${API_URL}/categories`, {
    headers: { Authorization: `Bearer ${token}` },
  });
};

export const addCategory = (category, token) => {
  return axios.post(`${API_URL}/categories`, category, {
    headers: { Authorization: `Bearer ${token}` },
  });
};