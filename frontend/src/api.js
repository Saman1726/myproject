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

export const addTransaction = async (transaction, token) => {
  try {
    const categoryRes = await getCategorieByName(token, transaction.category);
    transaction.category = categoryRes.data;

    return await axios.post(`${API_URL}/transactions`, transaction, {
      headers: { Authorization: `Bearer ${token}` },
    });
  } catch (error) {
    console.error("Error adding transaction:", error);
    throw error;
  }
};


export const getCategories = (token) => {
  return axios.get(`${API_URL}/categories`, {
    headers: { Authorization: `Bearer ${token}` },
  });
};

export const getCategorieByName = (token,name) => {
  return axios.get(`${API_URL}/categories/name/${name}`, {
    headers: { Authorization: `Bearer ${token}` },
  });
};

export const addCategory = (category, token) => {
  return axios.post(`${API_URL}/categories`, category, {
    headers: { Authorization: `Bearer ${token}` },
  });
};