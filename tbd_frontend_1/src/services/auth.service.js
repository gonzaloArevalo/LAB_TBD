import httpClient from "../http-common"

// const login = (loginDto) => {
//   return httpClient.post('/auth/login', loginDto)
//     .then((response) => {
//       // Asegúrate de capturar el token del header 'Authorization'
//       const token = response.headers;
//       if (token) {
//         // Guardar el token en localStorage
//         localStorage.setItem('token', token);
//         console.log("Token guardado en localStorage:", token); // Para verificar
//         console.log(token);
//       } else {
//         console.error("No se recibió el token en el header 'Authorization'");
//       }
//       return response;
//     })
//     .catch((error) => {
//       console.error("Error al hacer login", error);
//     });
// };

const login = (loginDto) => {
  return httpClient.post('/auth/login', loginDto)
    .then((response) => {
      // Captura el token del header 'Authorization'
      const token = response.headers['authorization'];
      if (token) {
        // Guardar solo el token en localStorage
        localStorage.setItem('token', `Bearer ${token}`);
        console.log("Token guardado en localStorage:", token);
      } else {
        console.error("No se recibió el token en el header 'Authorization'");
      }
      return response;
    })
    .catch((error) => {
      console.error("Error al hacer login", error);
    });
};

const register = registerDto => {
    return httpClient.post('/auth/register', registerDto);
}

export default {login, register};