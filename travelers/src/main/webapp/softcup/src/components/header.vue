<template lang="html">
  <div class="hf">
    <!-- phone:头，pc：脚 -->
  	<header>想去哪就去哪~</header>

    <!-- 导航 -->
  	<footer id="pcFoot">
  		<nav class="navbar">
  		  <div class="container-fluid">
  		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
  					<img src="../assets/img/hc.png" alt="宏创" />
  		      <ul class="nav navbar-nav">
              <router-link class="li" to="/">首页</router-link>
              <router-link class="li" to="/rob">抢票</router-link>
              <router-link class="li" to="/trip">旅程</router-link>
              <router-link class="li" to="/order">订单</router-link>
  		        <router-link class="li" to="/mine">我的</router-link>
  		      </ul>
  		    </div>
  		  </div>
  		</nav>
  	</footer>
  	<footer id="phoneFoot">
  		<div class="container-fluid">
  		  <div class="row">
  				<div class="col-xs-2"><router-link to="/">首页</router-link>
  				</div>
  				<div class="col-xs-3"><router-link to="/rob">抢票</router-link>
  				</div>
  				<div class="col-xs-3"><router-link to="/trip">旅程</router-link>
  				</div>
  				<div class="col-xs-2"><router-link to="/order">订单</router-link>
  				</div>
    			<div class="col-xs-2"><router-link to="/mine">我的</router-link>
  				</div>
  		  </div>
  		</div>
  	</footer>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="css" scoped>
/*pc端*/
@media screen and (min-width: 768px){
  .hf{
    position: fixed;
    z-index: 9999;
  }
  header{
    position: fixed;
    bottom: 0;
    width: 100%;
    height: 30px;
    line-height: 30px;
    text-align: center;
    background: #D56B60;
  }
  /* 导航栏 */
  #phoneFoot{display: none;}
  footer{
    position: fixed;
    top: 0;
    width: 100%;
    background: #D56B60;
    height: 10%;
    text-align: center;
    font-size:105%;
  }
  img{
    width: 120px;
    height: 50px;
    float: left;
    margin: 6px;
  }
  .navbar{
    margin-bottom: 0;
  }
  #pcFoot .navbar-nav > .li{
    text-decoration: none;
    color: white;
    line-height: 35px;
    margin-top: 15px;
  }
  .navbar-nav {
    float: right;
  }
  #pcFoot .navbar-nav > .li {
    display: inline-block;
    width: 100px;
    height: 33px;
    border-radius: 48px;
  }
  #pcFoot .navbar-nav > .li:hover {
    cursor: pointer;
    color: #000;
    background: white;
  }
}
/*手机端*/
@media screen and (max-width: 767px){
  header{
    position: fixed;
    top: 0;
    width: 100%;
    height: 10%;
    background: #D56B60;
    line-height: 340%;
    text-align: center;
    font-size:150%;
  }
  #pcFoot,#ipaidFoot{display: none;}
  footer{
    position: fixed;
    bottom: 0;
    width: 100%;
    height: 10%;
    background: #D56B60;
    line-height: 338%;
    text-align: center;
    font-size:148%;
  }
  footer li{
    list-style: none;
    float: left;
  }
  hr{
    border-top: 4px solid #F8F8FF;
  }
}
</style>
