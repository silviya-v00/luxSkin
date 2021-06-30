<template>
  <div >
    <div class = "container">
      <div class = "row">
        <div class="col-6">
          <b-carousel
            id="carousel-1"
            v-model="slide"
            :interval="2000"
            indicators
          >
            <b-carousel-slide active>
              <template #img>
                <img
                  class="d-block img-fluid w-100"
                  src="../assets/clear-skin.jpg"
                  alt="image slot"
                >
              </template>
            </b-carousel-slide>
            <b-carousel-slide>
              <template #img>
                <img
                  class="d-block img-fluid w-100"
                  src="../assets/care.jpg"
                  alt="image slot"
                >
              </template>
            </b-carousel-slide>
            <b-carousel-slide>
              <template #img>
                <img
                  class="d-block img-fluid w-100"
                  src="../assets/eye-mask.jpg"
                  alt="image slot"
                >
              </template>
            </b-carousel-slide>
          </b-carousel>
        </div>
        <div class="col-6">
         <p class="description">Lux Skin е българска козметика, вдъхновена от древната наука „Апитерапия“- лечение и красота с помощта на пчелни продукти.
            <br>Създадена с натурални съставки и вяра в бъдещето на пчелите, нашата козметика е посланието ни към света за запазването им като биологичен вид и надежда, че те ще оцелеят за поколенията.
            <br>Повлияни от науката епигенетика и идеите за природосъобразен, щастлив живот, нашите продукти са създадени, за да донесат релакс, благоденствие и щастие във всеки Ваш ритуал - от утрото до нощта!</p>
        </div>
      </div>
     </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Pattaya&display=swap');
.container {
  padding-top: 50px;

}
#carousel-1 {
  width: 100%;
  padding: 0 10px;
}
img {
  height: 500px;
  width: 500px;
}
.description
{
  width: 80%;
  margin-left: 20%;
  margin-right: 10%;
  padding: 50px;
  color: palevioletred;
  font-size: large;
  font-family: 'Pattaya', sans-serif;
}
</style>
