<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<jsp:include page="/header"/>
<section style="padding:10px; min-height:400px;">
	<h2>${msg}</h2>
	
	<form>
		<label>Select Salutation:
		<select name="solut">
			<option value="">----select----</option>
			<option value="Mr.">Mister</option>
			<option value="Ms.">Miss</option>
			<option value="Dr.">Doctor</option>
		</select>
		</label>
		<label>Enter UserName:<input type="text" name="unm" /></label>
		<button>DONE</button>
	</form>
</section>
<jsp:include page="/footer"/>