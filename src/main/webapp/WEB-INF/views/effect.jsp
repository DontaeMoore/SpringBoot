<html>
<head><title>First JSP</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<style>
<%@include file="/WEB-INF/includes/effect.css"%>
</style>
<body>
<div id="progressbar"></div>
<div id="scrollPath"></div>
<div class="container">
<section>
<h2>WWF History</h2>
<p>The World Wide Fund for Nature (WWF) is an international organization working on issues regarding the conservation, research and restoration of the environment, formerly named the World Wildlife Fund. WWF was founded in 1961.</p>
</section>

<section>
<h2>WWF's Symbol</h2>
<p>The Panda has become the symbol of WWF. The well-known panda logo of WWF originated from a panda named Chi Chi that was transferred from the Beijing Zoo to the London Zoo in the same year of the establishment of WWF.</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
 Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
  dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat
   non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
</section>

 <div class="row">
    <div class="col">
     <label for="fname">First name:</label><br>
      <input type="text" id="fname" name="fname"><br>
    </div>
    <div class="col-6">
      Column
    </div>
    <div class="col">
     <label for="fname2">First name:</label><br>
      <input type="text" id="fname2" name="fname"><br>
    </div>
  </div>
</div>
<script type="text/javascript">
let progress = document.getElementById('progressbar');
let totalHeight = document.body.scrollHeight - window.innerHeight;
window.onscroll = function() {
let progressHeight = (window.pageYOffset / totalHeight) * 100;
progress.style.height = progressHeight + "%";


}
</script>

</body>
</html>