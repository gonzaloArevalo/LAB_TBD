<template>
  <v-container class="payment-container py-16">
    <v-row justify="center">
      <v-col cols="12" md="8">
        <v-card class="pa-6">
          <v-card-title class="text-h5 text-center"
            >Detalle de la Compra</v-card-title
          >
          <v-divider class="my-4"></v-divider>

          <!-- Lista de productos -->
          <v-list>
            <v-list-item
              v-for="([producto, cantidad], index) in cart"
              :key="index"
              class="mb-4"
            >
              <v-list-item-content>
                <div>
                  <strong>{{ producto.nombre }}</strong>
                </div>
                <div>Cantidad: {{ cantidad }}</div>
                <div>Precio Unitario: ${{ producto.precio }}</div>
                <div>Subtotal: ${{ producto.precio * cantidad }}</div>
              </v-list-item-content>
            </v-list-item>
          </v-list>

          <v-divider class="my-4"></v-divider>

          <!-- Total -->
          <div class="d-flex justify-end align-center">
            <span class="text-h6 mr-4">Total:</span>
            <span class="text-h5 font-weight-bold">${{ total }}</span>
          </div>

          <!-- Botón de pagar -->
          <v-card-actions class="d-flex justify-center mt-4">
            <v-btn color="success" @click="pay" block>
              <v-icon left>mdi-credit-card-check</v-icon>
              Pagar
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>
  

<script>
import { jwtDecode } from "jwt-decode";

export default {
  inject: ["calcularSubtotal","vaciarCarrito"],

  name: "PaymentView",
  data() {
    return {
      cart: [], // Carrito de compras cargado desde localStorage
      total: 0, // Total calculado de la compra
      userID: "",
    };
  },

  mounted() {
    const savedCart = JSON.parse(localStorage.getItem("carrito"));
    if (savedCart) {
      this.cart = savedCart;
      this.total = this.calcularSubtotal();
    } else {
      this.$router.push({ name: "Home" });
    }
    const token = localStorage.getItem("token");
    if (token) {
      const decodedToken = jwtDecode(token);
      this.userID = decodedToken.id_cliente; // Almacena el id del cliente logueado
    }
  },

  methods: {
    pay() {
      if (this.cart.length === 0) {
        alert("El carrito está vacío. Agrega productos antes de pagar.");
        return;
      } else {
        alert(`¡Pago exitoso! El monto total es $${this.total}`);
        
        // Se crea objeto a enviar al backend
        const obj = {
          id_cliente: this.userID,
          cart: this.cart
        }

        // Servicio de orden.service para enviar carrito




        this.vaciarCarrito();
        // Redirigir a la página principal
        this.$router.push({ name: "Home" });
      }
    },
  },
};
</script>
  