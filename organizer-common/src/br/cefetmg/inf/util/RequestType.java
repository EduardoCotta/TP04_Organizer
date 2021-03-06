package br.cefetmg.inf.util;

public enum RequestType {
    
    //Package 
    NUMPACKAGE, RESPONSEPACKAGE,
    //User
    REGISTERUSER, SEARCHUSER, UPDATEUSER, DELETEACCOUNT, GETUSERLOGIN,
    // Item
    CREATEITEM, DELETEITEM, UPDATEITEM, LISTALLITEM, SEARCHITEMBYID, SEARCHITEMBYNAME,
                SEARCHITEMBYTAG, SEARCHITEMBYTYPE, SEARCHITEMBYTAGANDTYPE,
    // ItemTag
    CREATETAGINITEM, DELETETAGINITEM, LISTALLTAGINITEM, DELETETAGBYITEMID,
    // Tag
    CREATETAG, READTAG, UPDATETAG, UPDATETAGID, DELETETAG, LISTALLTAG, SEARCHTAGBYNAME, SEARCHTAGBYID,
    //MAX
    UPDATEALLITEMS, UPDATEALLTAGS, UPDATEALLITEMTAG, LOADITEMS, LOADTAGS, LOADTAGSITEMS, LOADITEMSTAGS;  

}
