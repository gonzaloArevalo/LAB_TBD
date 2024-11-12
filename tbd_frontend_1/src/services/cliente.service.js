import httpClient from "../http-common"

// const getAll = () => {
//     return httpClient.get('/api/cliente/');
// }

const getAll = () => {
  // Obtener el token de localStorage
  const token = localStorage.getItem('token');
  
  // Configurar el header Authorization si el token está disponible
  const headers = token ? { Authorization: token } : {};

  // Enviar la solicitud con el header
  return httpClient.get('/api/cliente/', { headers });
};

export default { getAll };

// const getAll = () => {
//   // Obtener el token de localStorage
//   const token = localStorage.getItem('token');
//   // Configurar el header Authorization si existe el token
//   const headers = token ? { Authorization: token } : {};

//   return httpClient.get('/api/cliente/', { headers });
// };
