import httpClient from "../http-common"

const getAll = () => {
  // Obtener el token de localStorage
  const token = localStorage.getItem('token');
  
  // Configurar el header Authorization si el token está disponible
  const headers = token ? { Authorization: token } : {};

  // Enviar la solicitud con el header
  return httpClient.get('/api/producto/', { headers });
};

export default { getAll };




