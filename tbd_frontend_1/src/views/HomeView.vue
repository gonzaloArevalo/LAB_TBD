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
  
    <v-row justify="center">

      <v-col cols="12" md="4">

        <v-btn color="primary" :to="{ name: 'Login' }">
          LINK A LOGIN
        </v-btn>
      
        <v-btn color="primary" :to="{ name: 'Register' }">
          LINK A REGISTER
        </v-btn>

      </v-col>


    </v-row>

  </v-container>

  <!-- <div v-if="users.length">
    <p v-for="(cliente,index) in users" :key="index">

      NOMBRE: {{ cliente.nombre }} CORREO: {{ cliente.email }}

    </p>
  </div> -->
</template>

<style scoped>
  .home-container {
    height: 100vh;
    display: flex;
    align-items: center;
    background-image: url('../assets/yotsuba.jpg');
    background-size: cover;
    background-position: center; 
    background-repeat: no-repeat; 
  }
  
  </style>


