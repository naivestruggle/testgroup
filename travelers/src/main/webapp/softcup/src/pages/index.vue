<template lang="html">
  <div>
    <section id="pc">
  		<div class="jumbotron"></div>
  		<div class="panel panel-default">
  		  <div class="panel-heading">
  		    <h3 class="panel-title">想去哪就去哪~</h3>
  		  </div>
  		  <div class="panel-body">
  				<article class="site">
            <div class="form-item">
              <label>出发地</label>
    					<div class="input-group input-group-sm">
                <input type="text" class="form-control" placeholder="你的位置" aria-describedby="sizing-addon3">
                <!-- .input-group-addon 点击获取城市 -->
                <span class="input-group-addon" id="sizing-addon3">
                  <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
                </span>
    					</div>
            </div>
            <div class="form-item">
              <label>到达地</label>
    					<div class="input-group input-group-sm">
                <input type="text" class="form-control" placeholder="你要去哪" aria-describedby="sizing-addon3">
                <!-- .input-group-addon 点击获取城市 -->
                <span class="input-group-addon" id="sizing-addon3">
                  <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
                </span>
    					</div>
            </div>
  				</article>
  				<article class="time">
            <div class="form-item">
              <label>出发日期</label>
    					<div class="input-group input-group-sm">
                <input type="text" class="form-control" placeholder="日期" aria-describedby="sizing-addon3">
                <!-- .input-group-addon 点击获取日历 -->
    						<span class="input-group-addon" id="sizing-addon3">
                  <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                </span>
    					</div>
            </div>
            <div class="form-item">
              <div class="input-group input-group-sm checkbox">
                <label><input type="checkbox">学生</label>
                <label><input type="checkbox">高铁/动车</label>
              </div>
            </div>
            <div class="change">
              <a href="#">换</a>
            </div>
  				</article>
  				<article class="search">
            <div class="form-item">
              <!-- 跳转查询页面 -->
    					<div class="btn btn-btn-default btn-lg">查询</div>
            </div>
  				</article>
  		  </div>
  		</div>
  	</section>
  	<section id="phone">
  		<article class="site">
        <div class="form-item">
          <div class="input-group input-group-sm">
            <input type="text" class="form-control" placeholder="你的位置" aria-describedby="sizing-addon3">
            <!-- .input-group-addon 点击获取城市 -->
            <span class="input-group-addon" id="sizing-addon3">
              <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
            </span>
          </div>
        </div>
        <div class="form-item">
          <div class="input-group input-group-sm">
            <input type="text" class="form-control" placeholder="你要去哪" aria-describedby="sizing-addon3">
            <!-- .input-group-addon 点击获取城市 -->
            <span class="input-group-addon" id="sizing-addon3">
              <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
            </span>
          </div>
        </div>
        <div class="change">
          <a href="#">换</a>
        </div>
  		</article>
  		<article class="time">
        <div class="form-item">
          <div class="input-group input-group-sm">
            <input type="text" class="form-control" placeholder="日期" aria-describedby="sizing-addon3">
            <!-- .input-group-addon 点击获取日历 -->
            <span class="input-group-addon" id="sizing-addon3">
              <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
            </span>
          </div>
        </div>
        <div class="form-item">
          <div class="input-group input-group-sm checkbox">
            <label><input type="checkbox">学生</label>
            <label><input type="checkbox">高铁/动车</label>
          </div>
        </div>
  		</article>
  		<article class="search">
  			<div class="btn btn-btn-default btn-lg">查询</div>
  		</article>
  	</section>
  </div>
</template>

<script>
export default {
}
</script>

<style lang="css" scoped>
/*pc端*/
@media screen and (min-width: 768px){
  #phone{
    display: none;
  }
  #pc{
    height: 600px;
    position: relative;
  }
  #pc .jumbotron{
    background: url('../assets/img/header.jpg') no-repeat;
    background-size:cover;
    height: 100vh;
    width: 100vw;
    margin: 0;
  }
  #pc .panel{
    width: 510px;
    height: 350px;
    position: absolute;
    left: 60px;
    top: 152px;
  }
  /* 居中 */
  #pc .panel-body{
    padding: 15px 50px;
  }
  #pc .panel-heading{
    background: #D56B60;
    height: 46px;
    padding: 15px 15px;
    color: #F8F8FF;
  }
  #pc .panel-default {
      border-color: #D56B60;
  }
  .form-item{
    margin-top: 16px;
  }
  article span{
    text-align: center;
    color: #000;
  }
  .change{
    position: absolute;
    top: 89px;
    right: 53px;
    width: 24px;
    height: 60px;
    border: 1px solid #DEDEDE;
    border-left: none;
  }
  .change > a{
    position: absolute;
    top: 18px;
    right: -13px;
    display: inline-block;
    border-radius: 50%;
    background: #DEDEDE;
    color: white;
    width: 25px;
    height: 25px;
    font-size: 14px;
    line-height: 25px;
    text-align: center;
  }
  label{
    color: #000;
    float: left;
    width: 75px;
    padding-right: 10px;
    text-align: right;
    margin-top: 6px;
  }
  .input-group-sm{
    padding-bottom: 10px;
    width: 307px;
    margin-left: 75px;
  }
  .search .btn{
    width: 382px;
    height: 30px;
    background-color: #D56B60;
    text-align: center;
    line-height: 10px;
    font-size: 14px;
    border-radius: 4px;
  }
  .search .btn:hover{
    color: #fff;
  }
  .input-group-addon:hover .glyphicon{
    color: #D56B60;
  }
  .input-group-addon:hover{
    cursor: pointer;
  }
  .checkbox{
    color: #000;
  }
  .checkbox label{
    width: 112px;
  }
  .checkbox input{
    width: 16px;
    height: 16px;
  }
}
/*手机端*/
@media screen and (max-width: 767px){
  #pc{
    display: none;
  }
  #phone{
    padding-top: 24%;
    height: 600px;
  }
  #phone article{
    margin: 22px 34px;
    font-size: 22px;
    text-align: center;
    color: #000;
  }
  .form-item{
    margin-top: 16px;
  }
  article .input-group{
    height: 44px;
  }
  .change{
    position: absolute;
    top: 142px;
    right: 45px;
    width: 24px;
    height: 75px;
    border: 1px solid #DEDEDE;
    border-left: none;
  }
  .change > a{
    position: absolute;
    top: 20px;
    display: inline-block;
    border-radius: 50%;
    background: #DEDEDE;
    color:white;
    width: 28px;
    height: 28px;
    font-size: 18px;
    line-height: 26px;
  }
  label{
    color: #000;
    float: left;
    width: 75px;
    padding-right: 10px;
    text-align: right;
    margin-top: 6px;
    font-size: 16px;
  }
  .input-group-sm{
    padding-bottom: 10px;
    width: 307px;
  }
  .input-group input{
    height: 44px;
  }
  .time{
    text-align: center;
    color: #000;
  }
  .search{
    margin: 0 20px;
  }
  .search .btn{
    width: 100%;
    height: 46px;
    background-color: #D56B60;
    text-align: center;
    line-height: 26px;
    border-radius: 4px;
  }
  .input-group-addon:hover .glyphicon{
    color: #D56B60;
  }
  .input-group-addon:hover{
    cursor: pointer;
  }
  .checkbox{
    color: #000;
  }
  .checkbox label{
    width: 112px;
  }
  .checkbox input{
    width: 16px;
    height: 16px;
  }
}
</style>
