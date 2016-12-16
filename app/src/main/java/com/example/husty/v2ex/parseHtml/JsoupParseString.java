package com.example.husty.v2ex.parseHtml;



import android.util.Log;

import com.example.husty.v2ex.parseJson.Item;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HUSTy on 2016/12/3.
 */

public class JsoupParseString {
    public List<ReplyItem> parseString(String htmlString){
        Document doc= Jsoup.parse(htmlString);
        Elements list=doc.select("div.cell");
        List<ReplyItem> replyItemList=new ArrayList<>();
        for(Element element:list){
            ReplyItem item=new ReplyItem();
            item.setUserName(element.select("table").select("tbody").select("td").select("a.dark").text());
            item.setContent(element.select("table").select("tbody").select("td").select("div.reply_content").text());
            item.setBitmapUrl(element.select("table").select("tbody").select("td").select("img").attr("src"));
            replyItemList.add(item);
        }
        return replyItemList;
    }
    //TODO:解析html结点

    public List<HtmlItem> parseStringToItem(String htmlString){
        List<HtmlItem> htmlItemList=new ArrayList<>();
        Document doc=Jsoup.parse(htmlString);
        Elements list=doc.select("[class=cell item]");
        for(Element element:list){
            HtmlItem item=new HtmlItem();
            item.setTitle(element.select("table").select("tbody").select("tr").select("td").select("span.item_title").select("a").text());
            item.setBitmapUrl(element.select("table").select("tbody").select("tr").select("td").select("img").attr("src"));
            item.setUrl("https://www.v2ex.com"+element.select("table").select("tbody").select("tr").select("td").select("span.item_title").select("a").attr("href"));
            item.setUsername(element.select("table").select("tbody").select("tr").select("td").select("[span=small fade]").select("strong").select("a").attr("href"));
            htmlItemList.add(item);
        }
        return htmlItemList;
    }

    public ItemConcreteData parseStringToConcreteItem(String htmlString){
        ItemConcreteData concreteData=new ItemConcreteData();
        Document doc=Jsoup.parse(htmlString);
        Elements elementZ=doc.select("div.header");
        Element element=elementZ.get(0);
        Elements elementM=doc.select("div.topic_content");
        Element elemen1=elementM.get(0);
        concreteData.setTitle(element.select("h1").text());
        concreteData.setUsername(element.select("small.gray").select("a").attr("href"));
        concreteData.setContent(elemen1.select("div.markdown_body").text());
        concreteData.setTime(element.select("small.gray").text());
        concreteData.setSign(element.select("a").attr("[href=/go/iphone]"));
        return concreteData;
    }
}
