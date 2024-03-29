<%@page import="javax.portlet.PortletURL"%>
<%@page import="net.carlosduran.liferay.impersonation.sb.model.ImpersonationRegistry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="init.jsp" %>

<%
PortletURL iteratorURL = renderResponse.createRenderURL();	
List<ImpersonationRegistry> impersonations = (List<ImpersonationRegistry>)renderRequest.getAttribute("impersonations");
%>

<div class="m-4">
    <div class="container">
	<h2 class="mb-4"><liferay-ui:message key="impersonations-registry"></liferay-ui:message></h2>
	<div id="sc-main">
		<liferay-ui:search-container delta="20" emptyResultsMessage="no-entries-to-list" iteratorURL="<%=iteratorURL%>" total="<%= impersonations.size() %>">
		    <liferay-ui:search-container-results  results="<%= ListUtil.subList(impersonations, searchContainer.getStart(), searchContainer.getEnd()) %>" />
		    <liferay-ui:search-container-row className="net.carlosduran.liferay.impersonation.sb.model.ImpersonationRegistry" keyProperty="impersonationRegistryId" modelVar="reg">
		        <liferay-ui:search-container-column-text name="col.real-user" value="${ reg.screenName }" />
		        <liferay-ui:search-container-column-text name="col.impersonated-user" value="${ reg.impersonatedScreenName }" />
		        <liferay-ui:search-container-column-text name="col.date">
		        	<fmt:formatDate type = "both" value = "${ reg.operationDate }" />
		        </liferay-ui:search-container-column-text>
		        <liferay-ui:search-container-column-text name="col.result">
		            <span class="text-uppercase">
		                <liferay-ui:message key="result.${ operationResults[reg.operationResult - 1] }" />
		            </span>

			    </liferay-ui:search-container-column-text>
		    </liferay-ui:search-container-row>		    
		    <liferay-ui:search-iterator  markupView="lexicon" />
		</liferay-ui:search-container>
	</div>
	</div>
</div>



