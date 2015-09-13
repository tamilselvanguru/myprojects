<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b>Welcome!!!</b>
<table>
<tr><td>
PartnerName:${addPartner.partnerName }
</td></tr>
<tr><td>
Group:${addPartner.group }
</td></tr>
<tr>
<td>
Address:
</td></tr>
<tr><td>
Street Address:${addPartner.streetAddress}
</td></tr>
<tr><td>
City:${addPartner.city }
</td></tr><tr><td>
State:${addPartner.state }
</td></tr><tr><td>
Zipcode:${addPartner.zipCode }
</td></tr>
</table>
</body>
</html>