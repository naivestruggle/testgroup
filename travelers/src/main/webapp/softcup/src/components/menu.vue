<template lang="html">
  <div>
    <ul>
      <li class="active">火车</li>
      <li>飞机</li>
      <li>轮船</li>
    </ul>
  </div>
</template>

<script>
export default {
}
</script>

<style lang="css" scoped>
div {
  margin-top: 100px;
}
ul{
  background: #f5f5f5;
  border-radius: 4px;
  width: 100%;
  padding: 16px 0;
}
li{
  list-style: none;
  width: 100%;
  line-height: 40px;
  text-align: center;
  color: #333;
}
li:hover{
  color: white;
  background-color: #D56B60;
  cursor: pointer;
}
</style>
