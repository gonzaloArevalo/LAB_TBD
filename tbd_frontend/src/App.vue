<script setup>

import clienteService from './services/cliente.service';
import { VBtn } from 'vuetify/components';
import { RouterLink, RouterView } from 'vue-router';

</script>

<script>
export default {
  name: 'App',
  data() {
    return {
      users: []
    }
  },
  components: {},
  methods: {
  },

  mounted() {
    clienteService.getAll()
      .then(response => {
        this.users = response.data; // Asignamos los datos de la respuesta
      })
      .catch(error => {
        console.error('Error al obtener los usuarios:', error); // Manejamos errores
      });
  }
}
</script>

<template>
  
  <v-btn color="primary">¡Hola, Vuetify!</v-btn>

  <div v-if="users.length">

    <p v-for="(cliente,index) in users" :key="index">

      NOMBRE: {{ cliente.nombre }} CORREO: {{ cliente.email }}

    </p>
  </div>

  <RouterView />

</template>

<style>

</style>
