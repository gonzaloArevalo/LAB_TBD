<template>
  <v-container class="login-container">
    <v-row justify="center">
      <v-col cols="12" md="4">
        <v-card class="pa-6">
          <v-card-title class="text-h5">Iniciar Sesión</v-card-title>
          <v-card-subtitle class="v-card-sub">
            <span>¿No tienes una cuenta?</span>
          </v-card-subtitle>
          <v-btn color="primary" class="ml-1">Registrarse</v-btn>
          <v-card-text>
            <v-form @submit.prevent="handleSubmit">
              <v-text-field
                v-model="email"
                label="Correo"
                placeholder="tu@ejemplo.com"
                prepend-inner-icon="mdi-email"
                outlined
                dense
              ></v-text-field>
              <v-text-field
                v-model="password"
                label="Contraseña"
                placeholder="Ingresa tu contraseña"
                prepend-inner-icon="mdi-lock"
                outlined
                dense
                type="password"
              ></v-text-field>
              <v-btn type="submit" color="primary">Iniciar Sesión</v-btn>
            </v-form>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>
  

<script>
export default {
  name: "Login",
  components: {},
  data() {
    return {
      email: '',
      password: ''
    };
  },
  methods: {
    handleSubmit() {
      // SE NECESITA FUNCION DE BACKEND PARA ENVIAR LAS CREDENCIALES
      console.log(this.email);
      console.log(this.password);
    }
  },
};
</script>
  
<style scoped>
.login-container {
  height: 100vh;
  display: flex;
  align-items: center;
}

.v-card {
  border-radius: 12px;
}

.v-card-title {
  font-weight: bold;
}

.v-card-sub {
  display: inline;
}


</style>
  