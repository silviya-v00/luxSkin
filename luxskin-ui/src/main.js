import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import * as axios from 'axios'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { BootstrapVue, IconsPlugin, BCarousel, BImg, CardPlugin, TablePlugin } from 'bootstrap-vue'

Vue.component('b-img', BImg)
Vue.component('b-carousel', BCarousel)
Vue.use(TablePlugin)
Vue.use(CardPlugin)
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.prototype.$axios = axios
Vue.config.productionTip = false

new Vue({
  router,
  store,
  axios,
  render: h => h(App)
}).$mount('#app')
