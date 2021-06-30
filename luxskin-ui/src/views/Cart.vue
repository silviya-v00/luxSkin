<template>
  <div class="cart">
    <form>
      <div class="form-group">
        <label for="exampleInputEmail1">Email</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required v-model="client.email" placeholder="Въведи имейл">
      </div>
      <div class="form-group">
        <label for="exampleInputName">Име</label>
        <input type="text" class="form-control" placeholder="Въведи име" id="exampleInputName" required v-model="client.name">
      </div>
      <div class="form-group">
        <label id="validationCustom04" class="form-label">Продукти</label>
        <select class="form-control" id="product" required v-model="client.product_name">
          <option v-for="fil in product" :key="fil">
            {{fil.name}}
          </option>
        </select>
      </div>
      <div class="order">
        <label>Количество: </label>
        <input type="text" v-model="client.count_client" value="1">
      </div>
      <button type="submit" class="btn btn-primary" v-on:click="saveClient">Поръчай</button>
    </form>
  </div>
</template>

<script>
import ProductService from '@/services/product-service'
import ClientService from '../services/client-service'

export default {
  name: 'Cart',
  data () {
    return {
      message: '',
      client: {
        name: ' ',
        email: '',
        product_name: '',
        count_client: '',
        price: ''
      },
      product: {
        name: ''
      }
    }
  },
  methods: {
    setData (response) {
      this.client = response.data()
    },
    saveClient () {
      ClientService.saveClientDB(this.client).then(
        response => {
          console.log(response)
          this.client = response.data
        },
        error => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.data.message.toString()
        })
    },
    priceAll () {
      this.price = this.price * this.count_client
    }
  },
  mounted () {
    ProductService.getAllProduct().then(
      response => {
        console.log(response)
        this.product = response.data
      }
    )
  }
}
</script>

<style scoped>
.form-group
{
  font-weight: bold;
  text-align: center;
  width: 500px;
  margin:auto;
  padding-bottom: 10px;
}
label
{
  color: orange;
  font-weight: bold;
}

.order input
{
  border: 1px solid #ccc;
  font-weight: bold;
  height: 33px;
  text-align: center;
  width: 30px;
  margin-top: 10px;
}
form .btn-primary
 {
   background: orange;
   color: black;
   font-size: 15px;
   margin-top: 10px;
   border: 2px solid darkorange;
 }
form
{
  padding-bottom: 120px;
  padding-top: 29px;
}
</style>
