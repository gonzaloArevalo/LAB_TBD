<script setup>

import clienteService from '../services/cliente.service';

</script>

<script>
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
  <v-btn color="primary">¡Hola, Vuetify!xd</v-btn>

  <v-btn color="primary">
    <router-link :to="{ name: 'Login' }">LINK A LOGIN</router-link>
  </v-btn>

  <!-- <div v-if="users.length">
    <p v-for="(cliente,index) in users" :key="index">

      NOMBRE: {{ cliente.nombre }} CORREO: {{ cliente.email }}

    </p>
  </div> -->
</template>


