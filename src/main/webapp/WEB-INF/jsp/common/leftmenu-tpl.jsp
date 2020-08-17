<ul id="menu" class="list-group">
	<li class="list-group-item">
		<a href="javascript:;"><span>Production</span></a>
		<ul>
			<li name="bid"><a href="/"><span>Item List</span></a></li>
			<li name="receive"><a href="#"><span>My Cart†</span></a></li>
			<li name="bidRequest"><a href="/"><span>My WishList</span></a></li>
			<li name="borrowBidReturn"><a href="/">Message<span>†</span></a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#"><span class="text-title">My Account</span></a>
		<ul class="in">
			<li name="accountInfo"><a href="#">Account Information</a></li>
			<li name="realAuth"><a href="/">Purchase Order</a></li>
			<li name="userFile"><a href="/">Sale Order</a></li>
			<li name="bankInfo"><a href="/">Payment Management</a></li>
			<li name="ipLog"><a href="/">Login record•</a></li>
			<li name="userInfo"><a href="/"> <span>–™</span>Personal Information</a></li>
		</ul>
	</li>

<#if currentMenu??>
<script type="text/javascript">
	$(".list-group-item li[name=${currentMenu}]").addClass("active");
</script>
</#if>