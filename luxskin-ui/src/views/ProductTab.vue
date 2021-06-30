<template>
  <div class="productTab">
    <div class="table">
      <b-table
        striped
        hover
        bordered
        :items="product"
        :fields="fields"
      >
        <template v-slot:cell(actions)="row">
          <a class="pb"><router-link :to="{ name: 'Cart', params: { id: row.item.id } }">Добави в количка</router-link></a>
        </template>
      </b-table>
  </div>
  </div>
</template>

<script>
import ProductService from '../services/product-service'

export default {
  name: 'Products',
  data () {
    return {
      rows: '',
      product: [{
        id: '',
        name: '',
        description: '',
        price: ''
      }],
      fields: [
        { key: 'name', label: 'Продукт' },
        { key: 'price', label: 'Цена' },
        { key: 'description', label: 'Описание' },
        { key: 'actions', label: 'Детайли' }
      ]
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
.productTab{
  background-color: #ffe6e6;
}
.table {
  color: purple;
  background-color: hotpink;
}
.pb a {
  color: pink;
  font-size: 15px;
  background-color: mediumvioletred;
  border: 2px solid mediumvioletred;
}
.pb:hover {
  background-color: palevioletred;
  color: white;
  border: 2px solid mediumvioletred;
}
</style>
