<script>
import Navbar from './components/Navbar.vue';
import Sidemenu from './components/Sidemenu.vue';

export default {
  name: "App",
  components: {
    Sidemenu,
  },
  data() {
    return {
      menuDrawer: false,
      cartDrawer: false,
      mostrarNavbar: true,
      carrito: [] // Arreglo de arreglos [[producto, cantidad], ...]
    };
  },
  watch: {
    $route(to) {
      this.mostrarNavbar = !["Login", "Register"].includes(to.name);
    }
  },

  mounted() {
    this.mostrarNavbar = !["Login", "Register"].includes(this.$route.name);

    // Cargar el carrito desde localStorage al iniciar
    const savedCarrito = JSON.parse(localStorage.getItem('carrito'));
    if (savedCarrito) {
      this.carrito = savedCarrito;
    }
  },
 
  methods: {
    toggleMenuDrawer() {
      this.menuDrawer = !this.menuDrawer;
    },
    toggleCartDrawer() {
      this.cartDrawer = !this.cartDrawer;
    },
    logout() {
      localStorage.removeItem("token");
      this.$router.push({ name: "Login" });
      // Vacía el carrito y elimina el valor de localStorage
      this.carrito = [];
      localStorage.removeItem("carrito");
    },
    agregarAlCarrito(producto) {
      const index = this.carrito.findIndex(([p]) => p.id_producto === producto.id_producto);

      if (index !== -1) {
        // Producto ya existe en el carrito
        const [, cantidad] = this.carrito[index];
        if (cantidad < producto.stock) {
          this.carrito[index][1]++; // Incrementar cantidad
        } else {
          alert('No se puede agregar más, se ha alcanzado el stock disponible.');
        }
      } else {
        // Producto no existe en el carrito
        this.carrito.push([producto, 1]);
      }

      console.log(this.carrito);

      // Guardar el carrito actualizado en localStorage
      localStorage.setItem('carrito', JSON.stringify(this.carrito));
    },
    eliminarDelCarrito(productoID) {
      const index = this.carrito.findIndex(([p]) => p.id_producto === productoID);

      if (index !== -1) {
        const [, cantidad] = this.carrito[index];
        if (cantidad > 1) {
          this.carrito[index][1]--; // Reducir cantidad
        } else {
          this.carrito.splice(index, 1); // Eliminar producto del carrito
        }
      }

      // Guardar el carrito actualizado en localStorage
      localStorage.setItem('carrito', JSON.stringify(this.carrito));
    },
  },
  provide() {
    return {
      agregarAlCarrito: this.agregarAlCarrito,
      eliminarDelCarrito: this.eliminarDelCarrito,
      logout: this.logout,
    };
  }
};
</script>

<template>
  <v-app>
    <Navbar />
    <v-app-bar v-if="mostrarNavbar" app>
      <v-app-bar-nav-icon @click="toggleMenuDrawer" />
      <v-toolbar-title>Mi Tienda</v-toolbar-title>
      <v-spacer></v-spacer>

      <v-btn text to="/">Inicio</v-btn>
      <v-btn text to="/products">Productos</v-btn>

      <v-btn icon @click="toggleCartDrawer">
        <v-icon>mdi-cart</v-icon>
      </v-btn>

      <v-btn color="primary" @click="logout">Cerrar Sesión</v-btn>
    </v-app-bar>

    <Sidemenu v-model="menuDrawer" />

    <v-navigation-drawer
      v-model="cartDrawer"
      app
      location="right"
      temporary
      width="300"
    >
      <v-list>
        <v-list-item v-for="([producto, cantidad], index) in carrito" :key="index">
          <v-list-item-title>{{ producto.nombre }}</v-list-item-title>
          <v-list-item-subtitle>Cantidad: {{ cantidad }}</v-list-item-subtitle>
          <v-btn color="warning" @click="eliminarDelCarrito(producto.id_producto)">Eliminar</v-btn>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>
