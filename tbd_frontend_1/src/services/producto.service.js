import httpClient from "../http-common"

const getAll = () => {
  // Obtener el token de localStorage
  const token = localStorage.getItem('token');
  
  // Configurar el header Authorization si el token está disponible
  const headers = token ? { Authorization: token } : {};

  // Enviar la solicitud con el header
  return httpClient.get('/api/producto/', { headers });
};

const getById = (id) => {
  //const token = localStorage.getItem("token");
  //const headers = token ? { Authorization: token } : {};
  return httpClient.get(`/api/producto/${id}`, { headers });
};

const update = (id, producto) => {
  //const token = localStorage.getItem("token");
  //const headers = token ? { Authorization: token } : {};
  return httpClient.put(`/api/producto/${id}`, producto, { headers });
};

const remove = (id) => {
  //const token = localStorage.getItem("token");
  //const headers = token ? { Authorization: token } : {};
  return httpClient.delete(`/api/producto/${id}`, { headers });
};

export default { getAll, getById, update, remove };




