<template>
  <div class = "back">
    <div id="app">
      <div id="nav">
        <div class="masthead mb-auto">
          <div class="inner">
            <div>
              <b-img class="logo" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjH6BwOQNyshDHEFfddQN9whVvM3GX6KYGFlcWHh7bsIl8clG3-lQyedQwjeRo_N9MPQ&usqp=CAU"
                     alt="Responsive image">
              </b-img>
            </div>
            <nav class="nav nav-masthead justify-content-center">
              <a class="nav-link active"> <router-link to="/">Начало</router-link></a>
              <a class="nav-link"> <router-link to="/products">Продукти</router-link></a>
              <a class="nav-link"> <router-link to="/contacts">Контакти</router-link></a>
              <a class="nav-link"> <router-link to="/cart">Количка</router-link></a>
              <a class="nav-link"> <router-link to="/login">Вход</router-link></a>
            </nav>
          </div>
        </div>
      </div>
      <router-view/>
      <footer class="align-content-lg-center" id="foot">
        <p>© 2021 LUX SKIN BULGARIA MADE BY S&S LTD.</p>
      </footer>
    </div>
  </div>
</template>

<style>
.back {
  background-color: #ffe6e6;
}
#app {
  font-family: sans-serif;
  text-align: center;
}
.logo {
  float: left;
  width: 250px;
  height: 70px;
  margin-left: 100px;
  margin-top: 20px;
}

#nav {
  background-color: #ffe6e6;
  height: 100px;
}
.nav-masthead{
  float: right;
  margin-right: 200px;
  font-size: large;
  margin-top: 20px;
  height: 70px;
}
#nav a {
  font-weight: bold;
  color: white;
  background-color:#f2d9d9;
  padding-top: 20px;
}

#nav a.router-link-exact-active {
  color: palevioletred;
}
#foot{
  background-color: #ffe6e6;
  color: palevioletred;
  margin-top: 142px;
  height: 30px;
  position: sticky;
  font-size: medium;
  text-align: center;
  font-weight: bold;
}
</style>
