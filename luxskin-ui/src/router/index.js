import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Products from '@/views/Products'
import Cart from '@/views/Cart'
import Login from '@/views/Login'
import ProductTab from '@/views/ProductTab'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/products',
    name: 'Products',
    component: Products
  },
  {
    path: '/contacts',
    name: 'Contacts',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Contacts.vue')
  },
  {
    path: '/cart',
    name: 'Cart',
    component: Cart
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/productTab',
    name: 'ProductTab',
    component: ProductTab
  }
]

const router = new VueRouter({
  routes
})

export default router
