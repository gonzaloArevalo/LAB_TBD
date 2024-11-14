<script>
export default {
  name: "App",
  data() {
    return {
      drawer: false,
      mostrarNavbar: true
    };
  },
  watch: {
    // Observa la ruta actual y actualiza `mostrarNavbar` cuando cambia
    $route(to) {
      this.mostrarNavbar = !["Login", "Register"].includes(to.name);
    }
  },
  mounted() {
    // Configura `mostrarNavbar` inicialmente basado en la ruta actual
    this.mostrarNavbar = !["Login", "Register"].includes(this.$route.name);
  },
  methods: {
    logout() {
      // Elimina el token del localStorage
      localStorage.removeItem("token");

      // Redirige al usuario a la vista de Login
      this.$router.push({ name: "Login" });
    }
  }
};
</script>

<template>
  <v-app>
    <!-- Navbar con botón para abrir el drawer -->
    <v-app-bar v-if="mostrarNavbar" app>
      <v-toolbar-title>Mi Tienda</v-toolbar-title>
      <v-spacer></v-spacer>

      <!-- Botón de carrito -->
      <v-btn icon @click="drawer = !drawer">
        <v-icon>mdi-cart</v-icon>
      </v-btn>

      <!-- Botón de cerrar sesión -->
      <v-btn color="primary" @click="logout">
        Cerrar Sesión
      </v-btn>
    </v-app-bar>

    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>

<style>
/* Aquí puedes agregar tus estilos adicionales */
</style>