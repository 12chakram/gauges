package com.idtracks.gauges.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {
	
	protected static Logger logger = Logger.getLogger(EmailService.class);

	public String sendHtmlEmail(String[] tomany, Object object,String createdItem) {
		
		
		String Id = "5";
		String name = "Test";
	
		/*
		 * String htmlBody = "<html><body>" +
		 * "<div style='background-color:lightgray'>" +
		 * "<div style='background-color:lightseagreen'><h2>Build Created</h2></div>"
		 * +
		 * "<h1 style='color:blue'>Your build has been created successfully and is ready to use. Please log in to DevOps for more information.</h1>"
		 * +
		 * "<Strong>Request ID:</strong><label>Here Id will add dynamically</label></br></br>"
		 * +
		 * "<Strong>Application Name:</strong><label>Here Id will add dynamically</label></br></br>"
		 * +
		 * "<Strong>Display Name:</strong><label>Here Id will add dynamically</label></br></br>"
		 * +
		 * "<Strong>Request Submitted On:</strong><label>Here Id will add dynamically</label></br></br>"
		 * +
		 * "<Strong>Approver Comments:</strong><label>Here Id will add dynamically</label></br></br>"
		 * +
		 * "<Strong>Note:</strong><label>Please login to Jenkins 20 minutes from when you receive this email. You will not have shell access to this VM.</label></br></br>"
		 * + "</div>" +
		 * "<div style='background-color:lightblue;text-align:end'>" +
		 * "<label>TM and copyright © 2013 Apple Inc. 1 Infinite Loop, Cupertino, CA 95014.</label>"
		 * + "</div>" + "</body>" + "</html>";
		 */

		/*String htmlBody = "<html><body>"
				+ "<div style='background-color:lightgray'>"
				+ "<div style='background-color:lightseagreen'><h2>Build Created</h2></div>"
				+ "<h1 style='color:blue'>Your Business has been created successfully and is ready to use. Please log in to<a href='http://localhost:8080/easyfinder'>EasyFinder</a>for more information.</h1>"
				+ "<Strong>Business ID:</strong>" + "<label>"
				+ dealership.getBuid()
				+ "</label></br></br>"
				+ "<Strong>Business Name:</strong>"
				+ "<label>"
				+ dealership.getName()
				+ "</label></br></br>"
				+ "<Strong>Display Name:</strong>"
				+ "<label>"
				+ dealership.getName()
				+ "</label></br></br>"
				+ "<Strong>Store Hours:</strong><label>Open:</label>"
				+ dealership.getStoreOpen()
				+ "<label>Close:</label>"
				+ dealership.getStoreClose()
				+ "</br></br>"
				+ "<Strong>Business Address:</strong><label>"
				+ dealership.getAddress()
				+ "</label></br></br>"
				+ "</div>"
				+ "<div style='background-color:lightblue;text-align:end'>"
				+ "<label>TM and copyright © 2013 EasyFinder Inc. Hyderabad, India 500072.</label>"
				+ "</div>" + "</body>" + "</html>";*/
		
		String Enteryourdescription ="Dynamic Content";
		
		String htmlbody3 ="<!DOCTYPE HTML PUBLIC '-//W3C//DTD XHTML 1.0 Transitional //EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'><html><head><title></title><meta http-equiv='Content-Type' content='text/html; charset=utf-8'><meta name='viewport' content='width=320, target-densitydpi=device-dpi'><style type='text/css'>"
		+"@media only screen and (max-width: 660px) { table[class=w0], td[class=w0] { width: 0 !important; }table[class=w10], td[class=w10], img[class=w10] { width:10px !important; }table[class=w15], td[class=w15], img[class=w15] { width:5px !important; }table[class=w30], td[class=w30], img[class=w30] { width:10px !important; }"
		+"table[class=w60], td[class=w60], img[class=w60] { width:10px !important; }table[class=w125], td[class=w125], img[class=w125] { width:80px !important; }table[class=w130], td[class=w130], img[class=w130] { width:55px !important; }table[class=w140], td[class=w140], img[class=w140] { width:90px !important; }table[class=w160], td[class=w160], img[class=w160] { width:180px !important; }"
		+"table[class=w170], td[class=w170], img[class=w170] { width:100px !important; }table[class=w180], td[class=w180], img[class=w180] { width:80px !important; }table[class=w195], td[class=w195], img[class=w195] { width:80px !important; }table[class=w220], td[class=w220], img[class=w220] { width:80px !important; }table[class=w240], td[class=w240], img[class=w240] { width:180px !important; }"
		+"table[class=w255], td[class=w255], img[class=w255] { width:185px !important; }table[class=w275], td[class=w275], img[class=w275] { width:135px !important; }table[class=w280], td[class=w280], img[class=w280] { width:135px !important; }table[class=w300], td[class=w300], img[class=w300] { width:140px !important; }table[class=w325], td[class=w325], img[class=w325] { width:95px !important; }"
		+"table[class=w360], td[class=w360], img[class=w360] { width:140px !important; }table[class=w410], td[class=w410], img[class=w410] { width:180px !important; }table[class=w470], td[class=w470], img[class=w470] { width:200px !important; }table[class=w580], td[class=w580], img[class=w580] { width:280px !important; }table[class=w640], td[class=w640], img[class=w640] { width:300px !important; }"
		+"table[class*=hide], td[class*=hide], img[class*=hide], p[class*=hide], span[class*=hide] { display:none !important; }table[class=h0], td[class=h0] { height: 0 !important; }p[class=footer-content-left] { text-align: center !important; }#headline p { font-size: 30px !important; }"
		+".article-content, #left-sidebar{ -webkit-text-size-adjust: 90% !important; -ms-text-size-adjust: 90% !important; }.header-content, .footer-content-left {-webkit-text-size-adjust: 80% !important; -ms-text-size-adjust: 80% !important;}img { height: auto; line-height: 100%;}}" 
		+"#outlook a { padding: 0; }body { width: 100% !important; }.ReadMsgBody { width: 100%; }.ExternalClass { width: 100%; display:block !important; }body { background-color: #ececec; margin: 0; padding: 0; }img { outline: none; text-decoration: none; display: block;}br, strong br, b br, em br, i br { line-height:100%; }h1, h2, h3, h4, h5, h6 { line-height: 100% !important; -webkit-font-smoothing: antialiased; }h1 a, h2 a, h3 a, h4 a, h5 a, h6 a { color: blue !important; }"
		+"h1 a:active, h2 a:active,  h3 a:active, h4 a:active, h5 a:active, h6 a:active {	color: red !important; }h1 a:visited, h2 a:visited,  h3 a:visited, h4 a:visited, h5 a:visited, h6 a:visited { color: purple !important; }table td, table tr { border-collapse: collapse; }.yshortcuts, .yshortcuts a, .yshortcuts a:link,.yshortcuts a:visited, .yshortcuts a:hover, .yshortcuts a span {color: black; text-decoration: none !important; border-bottom: none !important; background: none !important;}"
		+"code {white-space: normal;word-break: break-all;}"
		+"#background-table { background-color: #ececec; }"
		+"#top-bar { border-radius:6px 6px 0px 0px; -moz-border-radius: 6px 6px 0px 0px; -webkit-border-radius:6px 6px 0px 0px; -webkit-font-smoothing: antialiased; background-color: #043948; color: #e7cba3; }"
		+"#top-bar a { font-weight: bold; color: #e7cba3; text-decoration: none;}"
		+"#footer { border-radius:0px 0px 6px 6px; -moz-border-radius: 0px 0px 6px 6px; -webkit-border-radius:0px 0px 6px 6px; -webkit-font-smoothing: antialiased;}"
		/* Fonts and Content */
		+"body, td { font-family: HelveticaNeue, sans-serif; }"
		+".header-content, .footer-content-left, .footer-content-right { -webkit-text-size-adjust: none; -ms-text-size-adjust: none; }"
		/* Prevent Webkit and Windows Mobile platforms from changing default font sizes on header and footer. */
		+".header-content { font-size: 12px; color: #e7cba3; }"
		+".header-content a { font-weight: bold; color: #e7cba3; text-decoration: none; }"
		+"#headline p { color: #e7cba3; font-family: HelveticaNeue, sans-serif; font-size: 36px; text-align: center; margin-top:0px; margin-bottom:30px; }"
		+"#headline p a { color: #e7cba3; text-decoration: none; }"
		+".article-title { font-size: 18px; line-height:24px; color: #9a9661; font-weight:bold; margin-top:0px; margin-bottom:18px; font-family: HelveticaNeue, sans-serif; }"
		+".article-title a { color: #9a9661; text-decoration: none; }"
		+".article-title.with-meta {margin-bottom: 0;}"
		+".article-meta { font-size: 13px; line-height: 20px; color: #ccc; font-weight: bold; margin-top: 0;}"
		+".article-content { font-size: 13px; line-height: 18px; color: #444444; margin-top: 0px; margin-bottom: 18px; font-family: HelveticaNeue, sans-serif; }"
		+".article-content a { color: #00707b; font-weight:bold; text-decoration:none; }"
		+".article-content img { max-width: 100% }"
		+".article-content ol, .article-content ul { margin-top:0px; margin-bottom:18px; margin-left:19px; padding:0; }"
		+".article-content li { font-size: 13px; line-height: 18px; color: #444444; }"
		+".article-content li a { color: #00707b; text-decoration:underline; }"
		+".article-content p {margin-bottom: 15px;}"
		+".footer-content-left { font-size: 12px; line-height: 15px; color: #e2e2e2; margin-top: 0px; margin-bottom: 15px; }"
		+".footer-content-left a { color: #e7cba3; font-weight: bold; text-decoration: none; }"
		+".footer-content-right { font-size: 11px; line-height: 16px; color: #e2e2e2; margin-top: 0px; margin-bottom: 15px; }"
		+".footer-content-right a { color: #e7cba3; font-weight: bold; text-decoration: none; }"
		+"#footer { background-color: #043948; color: #e2e2e2; }"
		+"#footer a { color: #e7cba3; text-decoration: none; font-weight: bold; }"
		+"#permission-reminder { white-space: normal; }"
		+"#street-address { color: #e7cba3; white-space: normal; }"
		+"</style>"
		+"<!--[if gte mso 9]><style _tmplitem='33' >"
		+".article-content ol, .article-content ul {margin: 0 0 0 24px;padding: 0;list-style-position: inside;}</style>"
		+"<![endif]--><script type='text/javascript'>var NREUMQ=NREUMQ||[];NREUMQ.push(['mark','firstbyte',new Date().getTime()]);</script></head><body><table id='background-table' border='0' cellpadding='0' cellspacing='0' width='100%'>"
		+"<tbody><tr><td align='center' bgcolor='#ececec'><table class='w640' style='margin:0 10px;' border='0' cellpadding='0' cellspacing='0' width='640'><tbody><tr><td class='w640' width='640' height='20'></td></tr>"
		+"<tr><td class='w640' width='640'><table id='top-bar' class='w640' bgcolor='#00707b' border='0' cellpadding='0' cellspacing='0' width='640'>"
		+"<tbody><tr><td class='w15' width='15'></td><td class='w325' align='left' valign='middle' width='350'><table class='w325' border='0' cellpadding='0' cellspacing='0' width='350'><tbody><tr><td class='w325' width='350' height='8'></td></tr>"
		 +"</tbody></table><div class='header-content'><a href='http://preview.createsend1.com/t/d-e-l-l-r/'>Web Version</a><span class='hide'>&nbsp;&nbsp;|&nbsp; <a href='http://client.updatemyprofile.com/d-l-2AD73FFF-l-y' lang='en'>Update preferences</a>&nbsp;&nbsp;|&nbsp; <a href='http://preview.createsend1.com/t/d-u-l-l-j/'>Unsubscribe</a></span></div><table class='w325' border='0' cellpadding='0' cellspacing='0' width='350'>"
		 +"<tbody><tr><td class='w325' width='350' height='8'></td></tr></tbody></table></td><td class='w30' width='30'></td><td class='w255' align='right' valign='middle' width='255'><table class='w255' border='0' cellpadding='0' cellspacing='0' width='255'><tbody><tr><td class='w255' width='255' height='8'></td></tr>"
		 +"</tbody></table><table border='0' cellpadding='0' cellspacing='0'><tbody><tr>"
		  +"<td valign='middle'><a href='http://preview.createsend1.com/t/d-fb-l-l-t/' rel='cs_facebox'>"
		  + "<img src=http://localhost:8080/easyfinder/services/dealers/getimg/"+Id+"alt='Facebook icon' ='' border='0' width='8' height='14'></a></td>"
		  +"<td width='3'></td>"
		  +"<td valign='middle'><div class='header-content'><a href='http://preview.createsend1.com/t/d-fb-l-l-i/' rel='cs_facebox'>Like</a></div></td>"
		 +"<td class='w10' width='10'></td>"
		 +"<td valign='middle'><a href='http://preview.createsend1.com/t/d-tw-l-l-d/'><img src='https://img.createsend1.com/img/templatebuilder/tweet-glyph.png' alt='Twitter icon' ='' border='0' width='17' height='13'></a></td>"
		 +"<td width='3'></td>"
		 +"<td valign='middle'><div class='header-content'><a href='http://preview.createsend1.com/t/d-tw-l-l-h/'>Tweet</a></div></td>"
		        +"<td class='w10' width='10'></td>"
		        +"<td valign='middle'><a href='http://client.forwardtomyfriend.com/d-jddkk-Preview-k' lang='en'><img src='https://img.createsend1.com/img/templatebuilder/forward-glyph.png' alt='Forward icon' ='' border='0' width='19' height='14'></a></td>"
		        +"<td width='3'></td>"
		        +"<td valign='middle'><div class='header-content'><a href='http://client.forwardtomyfriend.com/d-jddkk-Preview-u' lang='en'>Forward</a></div></td>"
		    +"</tr>"
		+"</tbody></table>"
		            +"<table class='w255' border='0' cellpadding='0' cellspacing='0' width='255'>"
		                +"<tbody><tr><td class='w255' width='255' height='8'></td></tr>"
		            +"</tbody></table>"
		        +"</td>"
		        +"<td class='w15' width='15'></td>"
		   +"</tr>"
		+"</tbody></table>"
		                        
	+"</td></tr><tr><td id='header' class='w640' align='center' bgcolor='#00707b' width='640'>"
		    +"<table class='w640' border='0' cellpadding='0' cellspacing='0' width='640'>"
		        +"<tbody><tr><td class='w30' width='30'></td><td class='w580' width='580' height='30'></td><td class='w30' width='30'></td></tr>"
		        +"<tr>"
		            +"<td class='w30' width='30'></td>"
		            +"<td class='w580' width='580'>"
		                +"<div id='headline' align='center'>"
		                   +"<p>"
		                        +"<strong>"+name+"</strong>"
		                    +"</p>"
		                +"</div>"
		            +"</td>"
		            +"<td class='w30' width='30'></td>"
		        +"</tr>"
		    +"</tbody></table>"
		+"</td></tr>"
		                +"<tr><td class='w640' bgcolor='#ffffff' width='640' height='30'></td></tr>"
		                +"<tr id='simple-content-row'><td class='w640' bgcolor='#ffffff' width='640'>"
		    +"<table class='w640' border='0' cellpadding='0' cellspacing='0' width='640'>"
		        +"<tbody><tr>"
		            +"<td class='w30' width='30'></td>"
		            +"<td class='w580' width='580'>"
		                +"<repeater>"
		                    +"<layout label='Text only'>"
		                        +"<table class='w580' border='0' cellpadding='0' cellspacing='0' width='580'>"
		                            +"<tbody><tr>"
		                                +"<td class='w580' width='580'>"
		                                    +"<p class='article-title' align='left'>Add a title</p>"
		                                    +"<div class='article-content' align='left'>"
		                                        +Enteryourdescription
		                                    +"</div>"
		                                +"</td>"
		                            +"</tr>"
		                            +"<tr><td class='w580' width='580' height='10'></td></tr>"
		                        +"</tbody></table>"
		                    +"</layout>"
		                                        
		                    
		                    +"<layout label='Text with full-width image'>"
		                        +"<table class='w580' border='0' cellpadding='0' cellspacing='0' width='580'>"
		                            +"<tbody><tr>"
		                                +"<td class='w580' width='580'>"
		                                    +"<p class='article-title' align='left'>Add a title</p>"
		                                +"</td>"
		                            +"</tr>"
		                            +"<tr>"
		                               + "<td class='w580' width='580'><img label='Image' class='w580' border='0' width='580' src='http://localhost:8080/easyfinder/services/dealers/getimg/'"+Id+"></td>"
		                            +"</tr>"
		                            +"<tr><td class='w580' width='580' height='15'></td></tr>"
		                            +"<tr>"
		                                +"<td class='w580' width='580'>"
		                                    +"<div class='article-content' align='left'>"+Enteryourdescription+"</div>"
		                                +"</td>"
		                            +"</tr>"
		                            +"<tr><td class='w580' width='580' height='10'></td></tr>"
		                        +"</tbody></table>"
		                    +"</layout>"
		                                        
		                    
		                    +"<layout label='Text with right-aligned image'>"
		                        +"<table class='w580' border='0' cellpadding='0' cellspacing='0' width='580'>"
		                            +"<tbody><tr>"
		                                +"<td class='w580' width='580'>"
		                                    +"<p class='article-title' align='left'>Add a title</p>"
		                                    +"<table align='right' border='0' cellpadding='0' cellspacing='0'>"
		                                        +"<tbody><tr>"
		                                            +"<td class='w30' width='15'></td>"
		                                            +"<td><img label='Image' class='w300' border='0' width='300' src='https://img.createsend1.com/static/filler/300x180_fill.gif'></td>"
		                                        +"</tr>"
		                                        +"<tr><td class='w30' width='15' height='5'></td><td></td></tr>"
		                                    +"</tbody></table>"
		                                    +"<div class='article-content' align='left'>"
		                                        +Enteryourdescription
		                                    +"</div>"
		                                +"</td>"
		                            +"</tr>"
		                            +"<tr><td class='w580' width='580' height='10'></td></tr>"
		                        +"</tbody></table>"
		                    +"</layout>"
		                                        
		                    
		                    +"<layout label='Text with left-aligned image'>"
		                        +"<table class='w580' border='0' cellpadding='0' cellspacing='0' width='580'>"
		                            +"<tbody><tr>"
		                                +"<td class='w580' width='580'>"
		                                    +"<p class='article-title' align='left'>Add a title</p>"
		                                    +"<table align='left' border='0' cellpadding='0' cellspacing='0'>"
		                                        +"<tbody><tr>"
		                                            +"<td><img label='Image' class='w300' border='0' width='300' src='https://img.createsend1.com/static/filler/300x180_fill.gif'></td>"
		                                            +"<td class='w30' width='15'></td>"
		                                        +"</tr>"
		                                        +"<tr><td></td><td class='w30' width='15' height='5'></td></tr>"
		                                    +"</tbody></table>"
		                                    +"<div class='article-content' align='left'>"+Enteryourdescription
		                                    +"</div>"
		                                +"</td>"
		                            +"</tr>"
		                            +"<tr><td class='w580' width='580' height='10'></td></tr>"
		                        +"</tbody></table>"
		                    +"</layout>"
		                                                                                
		                    
		                    +"<layout label='Two columns'>"
		                        +"<table class='w580' border='0' cellpadding='0' cellspacing='0' width='580'>"
		                            +"<tbody><tr>"
		                                +"<td class='w275' valign='top' width='275'>"
		                                    +"<table class='w275' border='0' cellpadding='0' cellspacing='0' width='275'>"
		                                        +"<tbody><tr>"
		                                            +"<td class='w275' width='275'>"
		                                                +"<p class='article-title' align='left'>Add a title</p>"
		                                                +"<div class='article-content' align='left'>"+Enteryourdescription
		                                                +"</div>"
		                                            +"</td>"
		                                        +"</tr>"
		                                        +"<tr><td class='w275' width='275' height='10'></td></tr>"
		                                    +"</tbody></table>"
		                                +"</td>"
		                                +"<td class='w30' width='30'></td>"
		                                +"<td class='w275' valign='top' width='275'>"
		                                    +"<table class='w275' border='0' cellpadding='0' cellspacing='0' width='275'>"
		                                        +"<tbody><tr>"
		                                            +"<td class='w275' width='275'>"
		                                                +"<p class='article-title' align='left'>Add a title</p>"
		                                                +"<div class='article-content' align='left'>"+Enteryourdescription
		                                                +"</div>"
		                                            +"</td>"
		                                        +"</tr>"
		                                        +"<tr><td class='w275' width='275' height='10'></td></tr>"
		                                    +"</tbody></table>"
		                                +"</td>"
		                            +"</tr>"
		                        +"</tbody></table>"
		                    +"</layout>"
		                                        
		                                        
		                    
		                    +"<layout label='Image gallery'>"
		                        +"<table class='w580' border='0' cellpadding='0' cellspacing='0' width='580'>"
		                            +"<tbody><tr>"
		                                +"<td class='w180' valign='top' width='180'>"
		                                    +"<table class='w180' border='0' cellpadding='0' cellspacing='0' width='180'>"
		                                        +"<tbody><tr>"
		                                            +"<td class='w180' width='180'><img label='Image' class='w180' border='0' width='180' src='https://img.createsend1.com/static/filler/180x108_fill.gif'></td>"
		                                        +"</tr>"
		                                        +"<tr><td class='w180' width='180' height='10'></td></tr>"
		                                        +"<tr>"
		                                            +"<td class='w180' width='180'>"
		                                                +"<div class='article-content' align='left'>"+Enteryourdescription
		                                                +"</div>"
		                                            +"</td>"
		                                        +"</tr>"
		                                        +"<tr><td class='w180' width='180' height='10'></td></tr>"
		                                    +"</tbody></table>"
		                                +"</td>"
		                                +"<td width='20'></td>"
		                                +"<td class='w180' valign='top' width='180'>"
		                                    +"<table class='w180' border='0' cellpadding='0' cellspacing='0' width='180'>"
		                                        +"<tbody><tr>"
		                                            +"<td class='w180' width='180'><img label='Image' class='w180' border='0' width='180' src='https://img.createsend1.com/static/filler/180x108_fill.gif'></td>"
		                                        +"</tr>"
		                                        +"<tr><td class='w180' width='180' height='10'></td></tr>"
		                                        +"<tr>"
		                                            +"<td class='w180' width='180'>"
		                                                +"<div class='article-content' align='left'>"+Enteryourdescription
		                                                +"</div>"
		                                            +"</td>"
		                                        +"</tr>"
		                                        +"<tr><td class='w180' width='180' height='10'></td></tr>"
		                                    +"</tbody></table>"
		                                +"</td>"
		                                +"<td width='20'></td>"
		                                +"<td class='w180' valign='top' width='180'>"
		                                    +"<table class='w180' border='0' cellpadding='0' cellspacing='0' width='180'>"
		                                        +"<tbody><tr>"
		                                            +"<td class='w180' width='180'><img label='Image' class='w180' border='0' width='180' src='https://img.createsend1.com/static/filler/180x108_fill.gif'></td>"
		                                        +"</tr>"
		                                        +"<tr><td class='w180' width='180' height='10'></td></tr>"
		                                        +"<tr>"
		                                            +"<td class='w180' width='180'>"
		                                                +"<div class='article-content' align='left'>"+Enteryourdescription
		                                                +"</div>"
		                                            +"</td>"
		                                        +"</tr>"
		                                        +"<tr><td class='w180' width='180' height='10'></td></tr>"
		                                    +"</tbody></table>"
		                                +"</td>"
		                            +"</tr>"
		                        +"</tbody></table>"
		                    +"</layout>"
		                +"</repeater>"
		            +"</td>"
		            +"<td class='w30' width='30'></td>"
		        +"</tr>"
		    +"</tbody></table>"
		+"</td></tr>"
		                +"<tr><td class='w640' bgcolor='#ffffff' width='640' height='15'></td></tr>"
		                
		                +"<tr>"
		                +"<td class='w640' width='640'>"
		    +"<table id='footer' class='w640' bgcolor='#043948' border='0' cellpadding='0' cellspacing='0' width='640'>"
		        +"<tbody><tr><td class='w30' width='30'></td><td class='w580 h0' width='360' height='30'></td><td class='w0' width='60'></td><td class='w0' width='160'></td><td class='w30' width='30'></td></tr>"
		        +"<tr>"
		            +"<td class='w30' width='30'></td>"
		            +"<td class='w580' valign='top' width='360'>"
		            +"<span class='hide'><p id='permission-reminder' class='footer-content-left' align='left'></p></span>"
		            +"<p class='footer-content-left' align='left'><a href='http://client.updatemyprofile.com/d-l-2AD73FFF-l-o' lang='en'>Edit your subscription</a> | <a href='http://preview.createsend1.com/t/d-u-l-l-b/'>Unsubscribe</a></p>"
		            +"</td>"
		            +"<td class='hide w0' width='60'></td>"
		            +"<td class='hide w0' valign='top' width='160'>"
		            +"<p id='street-address' class='footer-content-right' align='right'></p>"
		            +"</td>"
		            +"<td class='w30' width='30'></td>"
		        +"</tr>"
		        +"<tr><td class='w30' width='30'></td><td class='w580 h0' width='360' height='15'></td><td class='w0' width='60'></td><td class='w0' width='160'></td><td class='w30' width='30'></td></tr>"
		    +"</tbody></table>"
		+"</td>"
		                +"</tr>"
		                +"<tr><td class='w640' width='640' height='60'></td></tr>"
		            +"</tbody></table>"
		        +"</td>"
			+"</tr>"
		+"</tbody></table>"
		+"<img src='https://createsend1.com/t/d-o-l-l/o.gif' style='height:1px !important; width:1px !important; border: 0 !important; margin: 0 !important; padding: 0 !important' width='1' height='1' border='0' alt='' />"
		+"</body></html>";

		

		// Recipient's email ID needs to be mentioned.
	  
		//String to = "kumarvayyala@outlook.com"; 
		//String[] tomany = {"chakram12@hotmail.com","kumarvayyala@outlook.com","devaskht@gmail.com","kumar.v18@gmail.com"}; 
		String from ="kumar.v18@gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		String userName = "kumar.v18@gmail.com";
		String password = "nenusaitham3";

		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");

		/*
		 * // Get the default Session object. Session session =
		 * Session.getDefaultInstance(properties);
		 */

		Session session = Session.getInstance(properties,new GMailAuthenticator(userName, password));

		try {

			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(htmlbody3, "text/html");
			mp.addBodyPart(htmlPart);

			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(userName));

			// Set To: header field of the header.
			// message.addRecipient(Message.RecipientType.TO,new
			// InternetAddress(to));

			InternetAddress[] addressTo = new InternetAddress[tomany.length];
			for (int i = 0; i < tomany.length; i++) {
				addressTo[i] = new InternetAddress(tomany[i]);
			}
			message.addRecipients(Message.RecipientType.TO, addressTo);
			

			// Set Subject: header field
			message.setSubject("Thank you for choosing EasyFinder");

			/**
			 * Now set the actual message
			 * message.setText("This is actual message for multiple mails");
			 * Send the actual HTML message, as big as you like
			 */
			message.setContent(mp);

			// Send message
			Transport.send(message);
			//System.out.println("Sent message successfully....");
			logger.debug("Sent message successfully...."+addressTo[0]);
			return "Sent message successfully.";

		} catch (MessagingException mex) {
			mex.printStackTrace();
			logger.debug("problem while sending Email to "+tomany[0]);
		}
		
		return "mail not send.";
	}
}
