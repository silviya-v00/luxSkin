<template>
  <div class="products">
    <b-container>
      <b-card-group align-v="center">
        <div class="row">
          <div v-for="fil in product" :key="fil" class="all-cards" >
            <div class="card" style="width:13.5rem; height: 450px">
              <img class="card-img-top" src="../assets/product1.jpg"/>
              <div class="card-body">
                <h5 class="card-title">{{fil.name}}</h5>
                <p class="card-text">{{fil.price}}</p>
              </div>
              <a class="pb"><router-link :to="{ name: 'ProductTab' }">Детайли</router-link></a>
            </div>
          </div>
        </div>
      </b-card-group>
    </b-container>
  </div>
</template>

<script>
import ProductService from '../services/product-service'

export default {
  name: 'Products',
  data () {
    return {
      product: [{
        name: '',
        description: '',
        price: '',
        id: ''
      }]
    }
  },
  mounted () {
    ProductService.getAllProduct().then(
      response => {
        console.log(response)
        this.product = response.data
      },
      error => {
        this.content =
          (error.response && error.response.data) ||
          error.message ||
          error.toString()
      }
    )
  },
  methods: {
    uploadImg: function () {
      var reader = new FileReader()
      reader.onload = function (e) {
        this.film.cover_art = e.target.result
      }
      reader.onerror = function (error) {
        alert(error)
      }
    }
  }
}
</script>

<style scoped>
.products{
  background-color: #ffe6e6;
}
.all-cards{
  margin-top: 30px;
  margin-left: 10px;
}
.card-img-top
{
  width: 100%;
  height: 45%;
}
.card-title
{
  height: 5%;
  font-family: sans-serif;
}
.card-text
{
  height: 25%;
  font-family: sans-serif;
  width: 80%;
  margin-left: 10%;
  margin-right: 10%;
  margin-top: 60%;
  font-weight: bold;
}
.pb {
  background-color: orange;
  font-size: 15px;
  border: 2px solid darkorange;
}
.pb:hover {
  background-color: palevioletred;
  border: 2px solid mediumvioletred;
}
a {
  color:black;
}
a:hover {
  color:pink;
}
</style>
