<template>
  <v-container class="login-container" fluid>
    <v-row justify="center">
      <v-col cols="12" md="4">
        <v-card class="pa-6">
          <v-card-title class="text-h5">Iniciar Sesión</v-card-title>
          <v-card-subtitle class="v-card-sub">
            <span>¿No tienes una cuenta?</span>
          </v-card-subtitle>
          <v-btn color="primary" class="ml-1" :to="{ name: 'Register' }">Registrarse</v-btn>
          <v-card-text>
            <v-form @submit.prevent="handleSubmit">
              <v-text-field
                v-model="usernamex"
                label="Nombre de usuario"
                placeholder="juanitoProGamer2012"
                prepend-inner-icon="mdi-account"
                outlined
                dense
                :rules="[rules.required]"
              ></v-text-field>
              <v-text-field
                v-model="passwordx"
                :rules="[rules.required]"
                label="Contraseña"
                placeholder="Ingresa tu contraseña"
                prepend-inner-icon="mdi-lock"
                outlined
                dense
                @click:append-inner="show1 = !show1"
                :type="show1 ? 'text' : 'password'"
                :append-inner-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
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

import authService from '../services/auth.service';

export default {
  name: "Login",
  components: {},
  data() {
    return {
      usernamex: '',
      passwordx: '',
      show1: false,
      data: [],
      rules: {
          required: value => !!value || 'Requerido.',
        }
    };
  },
  methods: {
    handleSubmit() {
      const username = this.usernamex;
      const password = this.passwordx;
      const loginDto = {username, password};
      // Se intenta login
      authService.
      login(loginDto)
      .then((response) => {
        console.log("Se logeo", response.data);
        this.data = response;
      })
      .catch((error) => {
        console.log("ERROR AL LOGUEARSE",error);
      });

      // SI NO ESTA LA PASS Y EL EMAIL NO SE HACE LOGEA

      // SE NECESITA FUNCION DE BACKEND PARA ENVIAR LAS CREDENCIALES
      console.log(this.usernamex);
      console.log(this.passwordx);
      console.log(this.data);
      // this.$router.push({ name: 'Home' });
    }
  },
};
</script>
  
<style scoped>
.login-container {
  height: 100vh;
  display: flex;
  align-items: center;
  background-image: url('../assets/yotsuba.jpg');
  background-size: cover; /* Cubre toda la pantalla */
  background-position: center; /* Centra la imagen */
  background-repeat: no-repeat; /* Evita que se repita la imagen */
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
  