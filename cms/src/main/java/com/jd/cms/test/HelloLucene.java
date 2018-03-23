package com.jd.cms.test;

import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
//import java.nio.file.Paths;

public class HelloLucene {
    /**
     * 创建索引
     */
    public void index() {
        //1.创建Directory
//        Directory directory = new RAMDirectory();
//        Directory directory2 = FSDirectory.open(new File("/tmp/testindex"));
        IndexWriter indexWriter=null;
        try {
            Directory directory = FSDirectory.open(Paths.get("D:/InstallDest/lucene-7.2.1/testLuceneFSD"));
            //2.创建IndexWriter
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig();
            indexWriter  = new IndexWriter(directory, indexWriterConfig);
            //3.创建Document对象
            Document doc = null;
            //4.为Document添加Filed
            File files = new File("D:\\InstallDest\\lucene-7.2.1\\testLucene");
            for (File f : files.listFiles()) {
                doc = new Document();
//            doc.add(new Field("content",new FileReader(f),TextField.TYPE_NOT_STORED));
                doc.add(new TextField("content", new FileReader(f)));
                doc.add(new StringField("fileName", f.getName(), StringField.Store.YES));
                doc.add(new StringField("path", f.getAbsolutePath(), StringField.Store.YES));
                //5.通过IndexWriter添加文档到索引中
                indexWriter.addDocument(doc);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(indexWriter != null){
                try {
                    indexWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public void search(){
        //1.创建Directory

        DirectoryReader reader=null;
        //2.创建IndexReader
        try {
            Directory directory = FSDirectory.open(Paths.get("D:/InstallDest/lucene-7.2.1/testLuceneFSD"));
            reader = DirectoryReader.open(directory);

            //3.根据IndexReader创建IndexSearch
            IndexSearcher searcher = new IndexSearcher(reader);
            //4.创建搜索的Query
            TermQuery termQuery = new TermQuery(new Term("content","zcy"));
            //5.根据search搜索并且返回TopDocs
            TopDocs topDocs = searcher.search(termQuery,4);
            //6.根据TopDocs获取ScoreDocs对象
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            //7.根据search和ScoreDoc对象获取具体的Document对象
            for(ScoreDoc doc : scoreDocs){
                Document d = searcher.doc(doc.doc);
                System.out.println("fileName:"+d.get("fileName")+"\\n"+"path:"+d.get("path"));
            }
            //8.根据Documen对象获取需要的值






        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }

}

