<script>

import clienteService from '../services/cliente.service';

export default{
  name: 'Home',
  data() {
    return{
      users: []
    }
  },
  mounted() {
    // clienteService.getAll()
    //   .then(response => {
    //     this.users = response.data; // Asignamos los datos de la respuesta
    //   })
    //   .catch(error => {
    //     console.error('Error al obtener los usuarios:', error); // Manejamos errores
    //   });
  }
}
</script>

<template>
  
  <v-container class="home-container" fluid>
    <v-row class="bg-surface-variant" justify="center">
      <v-col cols="4" class="bg-pink text-center">
        <v-btn color="primary" :to="{ name: 'Login' }">
          LINK A LOGIN
        </v-btn>
      </v-col>

      <v-col cols="4" class="bg-green text-center">
        <v-btn color="primary" :to="{ name: 'Register' }">
          LINK A REGISTER
        </v-btn>
      </v-col>

      <v-col cols="4" class="bg-purple text-center">
        <v-btn color="primary" :to="{ name: 'Products' }">
          LINK A PRODUCTOS
        </v-btn>
      </v-col>

    </v-row>
  </v-container>
</template>

<style scoped>
  .home-container {
    height: 100vh;
    display: flex;
    align-items: center;
    /* background-image: url('../assets/yotsuba.jpg');
    background-size: cover;
    background-position: center; 
    background-repeat: no-repeat;  */
  }
  </style>


