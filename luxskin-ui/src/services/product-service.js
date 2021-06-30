import axios from 'axios'

const API_URL = 'http://localhost:8080/product'

class ProductService {
  getAllProduct () {
    return axios.get(API_URL + '/all')
  }

  getProductById (id, name, description, price) {
    return axios.get(API_URL + '/search/id',
      {
        params:
          {
            id: id,
            name: name,
            description: description,
            price: price
          }
      })
  }

  getProductByName (name) {
    return axios.get(API_URL + '/search/name',
      {
        params:
          {
            name: name
          }
      })
  }
}

export default new ProductService()
