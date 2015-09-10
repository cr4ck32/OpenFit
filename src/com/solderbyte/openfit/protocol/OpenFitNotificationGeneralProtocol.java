package com.solderbyte.openfit.protocol;

import com.solderbyte.openfit.OpenFitApi;

/*
    020400000005000000 heart rate 82BPM
    020400000005000000 heart reate 83BPM
    020400000005000000 heart rate ready?
    020400000005000000 after done running
    
    exercise: 
    02040000001B000000 cycling?
    02040000001B000000 start?
    02040000001B000000
    
    running: 
    020400000012000000021000000013000000020000007A142F4359DAC742
    rec gps: 
    020400000012000000021000000013000000030000007A142F4359DAC742
    starting? 
    020400000012000000021000000013000000020000007A142F4359DAC742
    
    running done: 
    02040000000A000000
    02040000000A000000 failed?
    02040000000A000000 after hitting stop running
    
    
    public void createSReportProtocol()
  {
    this.dataByteArray = createNotificationProtocol(AbstractNotificationProtocol.EDataType.DATA_TYPE_REPORT.ordinal(), this.mIndex, this.mDataList, this.mTime);
  }
  DATA_TYPE_REPORT = new EDataType("DATA_TYPE_REPORT", 38); hex 26
      
      //hex 148
    02940000000201000000ff0800000032000000000000000000000000704c44214f010000ffffffff0000000000000000ffffffffffffffffff00000000000000000a00000001000000c0b7c855000000000a0000000000000000003b40000000000100000046b5c855102700000000000045b5c8552300000000002a430000824235e60200f1490200d1fb01001198020022bf0200cd7fcf12
    02940000000201000000ff0800000032000000000000000000000000704c44214f010000ffffffff0000000000000000ffffffffffffffffff00000000000000000a00000001000000c0b7c855000000000a0000000000000000003b40000000000100000046b5c855102700000000000045b5c8552300000000002a430000824235e60200f1490200d1fb01001198020022bf0200cd7fcf12
    02940000000202000000ff08000000320000000000000000000000000c6444214f010000ffffffff0000000000000000ffffffffffffffffff00000000000000000a00000001000000c0b7c855000000000a0000000000000000003b40000000000100000046b5c855102700000000000045b5c8552300000000002a430000824235e60200f1490200d1fb01001198020022bf0200cd7fcf12
    02940000000203000000ff0800000032000000000000000000000000be6c45214f010000ffffffff0000000000000000ffffffffffffffffff00000000000000000a00000001000000c0b7c855000000000a0000000000000000003b40000000000100000046b5c855102700000000000045b5c8552300000000002a430000824235e60200f1490200d1fb01001198020022bf0200cd7fcf12
    
    respond after sync request
    02080000000300000001000000
    02080000000300000001000000
    
    heart beat?
    02050000000001000000
    02050000000002000000
    02050000000003000000

    DATA from watch
    02B11B00000400000004000000FF04B00100000853A955820100003ECA97433333A741B857A9551000000085EB5141AE47613F105AA9553A0100002A1C7C43B1478941685CA955010000008FC2353FCDCC4C3DC05EA95528000000EC51E84114AE0740089EA95579000000CCCCC4423333D34078DCAF5524000000295CDD41A170FD3F28E1AF55330100003D4A6B430AD78341D8E5AF555100000052B87642F6288C40E0ECAF5543000000703D50426666664038EFAF5525020000B9FED9433433ED4190F1AF5512000000000050418FC2753FE8F3AF5550020000D623EE43C2F5004298F8AF55C1000000703D1643A4702541F0FAAF554C00000052B86C4233338340A806B055D60000000A572943C3F538410009B055D9000000C2F53143EC514441B00DB0551C0000001F859D413E0AB73F6012B055B0000000C275FD42BA1E1541B814B0551D0000008FC2AB4114AEC73F1017B0553C00000052B83B42D7A35040C01BB055710000005C0FAD423433C340181EB0556F0000001E05A842AE47C140E037B055700000005C8FAD42295CBF404848B0555D0000001F859642713DA240A04AB0553D02000071BDE54314AEF9417808B155A100000090C2004347E10E41D00AB1556D010000D8639343CDCC9E418816B155B70000009A590E4385EB1D41E018B15542000000F6284E425C8F6240381BB1550F00000052B82A41713D4A3F4022B1550F0000005C8F2E41D7A3703FF026B155E00000007A54324349E142410035B155CF01000033D3B1430BD7C5415837B155A4000000846BFF42D7A30C41B039B155C9000000CD0C1A431F852B41603EB155A5000000856BFB42AF470D411043B155EE00000085AB314386EB49416845B155260000007B14EC415C8F0240C047B15513000000713D8641713D8A3F184AB15567000000AEC79B42295CAF40704CB15547000000285C594214AE7740C84EB15513000000D7A35C410AD7833F2051B1553800000014AE2F425C8F42407853B1557500000034B3BD42285CCF402858B1552A0000000BD7FD4133331340805AB155610000000A579A42295CAF40D85CB1559E000000285CF24266660A41305FB15525000000285CD74147E1FA3F9068B15512000000F62854413333733F986FB1550C0000005C8F1E417B142E3F4874B15510000000F62894417B148E3FA076B155160100003E4A564317AE7341F878B15517000000CDCC864148E19A3FA87DB155CC000000F6A81E43AE4731410080B155FA000000B1474B434BE15A416089B155E0010000EB71BB4347E1CE41B88BB155E8010000AE67C2437B14D4411895B15597000000D7
    A3FA42CDCC0841E8B5B1553B00000000004442E17A544080F8B85531000000A47015423D0A2740D8FAB8554A00000015AE7342713D82409006B955E3000000856B324332334741E808B9554600000033335F4285EB71404812B9551100000054B85641C3F5683FA014B95598000000D7A3EB4214AE0341001EB955AE010000F608A7436866B8415820B955460100009A598243A4708D41B022B955460000005D8F5C4278146E400825B955630000000BD793422E5CA740102CB9554200000014AE4B42E27A6440203AB955670000005C8FAD4252B8BE40783CB955B4000000281C0A4300002041D03EB955000000000000000000000000884AB955CB000000AE471F4335332F41E04CB95584000000D8A3DA42F628F4404056B955850000009999C1423833E3409858B9552D000000C3F5024266661640F05AB95512000000CDCC84411F858B3FF861B955FC000000EC914843020060410870B9553100000000001842C2F528406072B9558F000000D723E04252B8F640B874B9551D01000009576C43208585416879B95547000000F6285C42B81E75402085B955660000009899A1423C0AAF407887B9550F0000003D0A3341E17A543FD089B955C10000000000244347E12E41288CB9556C000000D723AF420000C040584CBA554F010000F6E8884384EB95416053BA5510000000000044419A99593FB855BA550B010000D7234C43D8A36441C05CBA55C8000000846B2443E07A3041E8CABA550E010000EC915143DCA3684140CDBA553A000000CDCC3D42CDCC4C40A0D6BA55420000005C8F464252B85E4050DBBA55230000005C8FD641D7A3F03FA8DDBA5522000000EC51D8411F85EB3F00E0BA55AB00000086EB06439999154158E2BA5533000000D7A313429A992940B0E4BA55860000006666C942CECCEC40D89DBB552600000048E1E241EC51084030A0BB557D000000EBD1BA42B91ED540E0A4BB551C01000085AB6043E47A784190A9BB55020100007A944C4304006441E8ABBB55A20000000A57FA425C8F0A4140AEBB554D0000005C8F6B423433834000AFBE5511000000713D4A417B146E3F58B1BE55A00000003E4A0243E17A1041B0B3BE554E000000B81E75429A99894008B6BE552E010000D6237E43703D8A4160B8BE5560010000860B9743AE479F41B8BABE554701000071DD834399999541C0C1BE5522000000EC51E241D7A3F03F18C4BE55C6000000C3F52243E27A344170C6BE5565010000A410914390C29D4128D2BE551000000048E15241AE47613F80D4BE5586020000A4B005445C8F12425892BF55BD000000C3B51D4300002C416099BF5592
    000000E27AE44252B8FE40B89BBF55940000000A57E84200000041C0A2BF55640000008EC29D42CCCCAC40D8B7BF55C5000000CC4C1443B91E2941E0BEBF55CE0100003453B3439899C94138C1BF5534020000EDD1DC439699F14190C3BF5545010000D7A37B43CDCC8A4198CABF55C7000000146E1C431F852B41F8D3BF555E0000009042994286EBA94050D6BF558A000000AEC7DA42D8A3F040A8D8BF550F000000AE473541295C4F3F8000C0553D00000014AE3942285C4F40D802C0559D000000D623EC42F8280441380CC055F80000000B57424334335741F017C0555E000000D7A38F429A99A140481AC055020100000C174B4348E16241A01CC0551700000052B88E41A4709D3FF81EC055B700000066E60B433E0A1F415021C05541000000C3F546422A5C5F40A823C0551900000052B89041C3F5A83F0026C055540000003E0A794285EB9140082DC0552700000014AE004248E10A40602FC055200000008FC2BD419A99D93FD8E3C0557F00000084EBD04208D7E34038EDC05587000000E2FAD24214AEE740E8F1C05596000000F628EF42A3700141A0FDC05541000000F6285542323363405002C1556E0000006666A6421F85C3400007C1558B000000E1FADB42E47AF4406817C155930000006F3DD842608FFA40C019C15560000000CCCC8F4289EBA140181CC155B70000007B540A43E17A2041701EC1558F0000003D8AE64285EBF9407825C155C1000000D763174352B826418833C15566000000F7289D4255B8AE40E035C155300100004F386343030080414846C15556000000A470854288EB9140A048C15549000000A4705D42F6287C40504DC15546000000B81E5F420AD77340A84FC1552F000000CDCC2442295C2F400052C1555B000000A4708A42F6289C40B056C155660000007A14A6423333B3400859C15578000000152EC242AF47D1407069C155C2000000E27A174385EB2941C86BC155850000001E85D0422485F3407870C1553B0000005C8F2E42EC514840D072C15578000000703DB7420000D0402875C1552A000000CDCC044285EB1140D879C15556000000B89E8B4285EBA140307CC155A5000000F6680B4391C21D41887EC1553A0000007A143242A4704D403883C15512000000E07A544114AE873F9085C1551C0000007B14A841F628BC3FE887C15537000000D7A31842EC513840408AC15500010000CCCC454324855B41988CC1550A020000A670BB43BEF5DA41F08EC155F4000000AF473743EB515041A093C155900000006666DF4252B8F640F895C1558C0000000080DE42E27AF44070B4C155610000001F059442CDCCA440C8
    B6C15500020000AE07BD43CECCD64120B9C155170000008FC275413333B33F78BBC155370000001F851F42285C3F40D0BDC155740000005D8FA4420AD7C340B037C255A40000009A590B43A47019416843C2556500000000809B42F428AC40C045C255AA000000EA5103432A5C1341305DC2554B0000002A5C6942D7A38040885FC25519010000B9DE5B43343373413864C2550E010000E4FA40436B6662419066C25504010000C1B53D438EEB5941E868C255B8000000E17A0F43285C1F41F06FC2555700000048E18442B81E9540A074C25520000000B81ED1410000E03FF876C255E300000021853B43CAF54C415079C255000000000000000000000000A87BC2550B000000F728FC4052B81E3FC090C25551000000B81E72420AD78B407095C2558E000000713DE442713DFA40C897C2555D000000EB5192421F85A340789CC255B500000033330C43B91E1D4130A8C255130000005D8F7641C3F5883FE0ACC2554800000086EB634211AE774038AFC255B2000000EB1111439A99214198B8C25589020000832BF643A1700A42F8C1C255A4000000717D02430000104150C4C25548000000C2F55942B81E7540A8C6C25526000000EC51DC4152B8FE3F00C9C255290000007B140542AE471140D8F0C255160000008FC28F41F6289C3FD886C3557B0000000000C5426766D6403890C355290000007B14FC41F6280C40E894C3556E000000D7A3A842B81EBD404097C3558E0000007B94E3423E0AF740F09BC35552000000486188427B149640489EC3558B0000005C8FDF42FFFFF74058ACC3559D000000B99EF6425C8F0A41B0AEC355450000009A995842295C6F4060B3C35511000000666646410AD7633FB8B5C3551400000066668441295C8F3F10B8C355B0000000CD8C0A430AD7174170C1C3550D00000014AE0B416766263F28CDC355940000002005F24215AE034180CFC35524000000FFFFCB41F328FC3FD8D1C3554D0000001F856E42E17A844088D6C35541000000AD474942A1705D40E0D8C35561000000676694426666A64058F7C35537000000AE472D4233334340B0F9C355AC000000713D1143F7281C4108FCC3559000000028DCDC42285CF740B800C455150000009A9979413333933F1003C455C700000090021643A47029416805C455110000009A993541F6285C3FC007C45545000000000053425C8F72407813C455ED000000A4703D4385EB4D41D015C4553100000090C21C4248E12A402818C455B9000000D7E31443295C234158D8C455A8000000CE8C0B43D8A31441B8E1C4558D0000003E8AD542C2F5F04068E6C4555E00000014AE944232
    33A34028F9C4556F0000005C0FB1420000C04080FBC4550901000071FD4943686662413000C5558A010000860B97439999A7418802C55515010000291C574333336F419009C555860000004761D242B81EE540E80BC55550000000A4707D4248E18A40400EC5556B000000CD4CB042CCCCBC40A017C5556300000052389D42AE47B140F819C55525000000EC51D0418FC2F53F501CC55570000000CD4CA7423D0ABF401836C55546000000713D4942C3F56840203DC5555C00000048618B42CCCC9C40783FC5550E00000014AE1F41EC51383F8046C5550700000014AEC740CDCCCC3E304BC5558700000014AED4429E99E940884DC5555C0000000A578A420AD79B40E04FC555ED000000E27A3043C2F548413852C5550C000000D7A30841AE47213FF05DC555B900000000C00E4390C22141D06DC655E00000009A9933435D8F4A41E07BC6552A0000003E0AF941F6280C40E882C655830000007B94BD425D8FDA40488CC65523000000713DD4417B14EE3FA08EC655DB000000F5A82E439A994541A895C6551C0000006666984148E1BA3F0098C6550C000000713D12416666263F589AC65572000000F6A8A942C2F5C84030C2C6557D000000B89ECB426666DE4038C9C655AF000000AEC70A43703D1A4190CBC65527000000AE47F341A4700D40F8BCC7555A000000A4709642F628A44050BFC755350100001F85764390C28741A8C1C755FF000000852B55436866664158C6C7553800000085EB3142AE474140B0C8C75592000000703DDD42F628004108CBC7551000000066662A410000803F60CDC755100000009A9945419A99593FC8DDC7551A0000003433A34190C2B53FD0E4C755B7000000EA510E43B81E214128E7C755960000009A19E542AE47014180E9C755110000007B1482416666863F88F0C75526000000B81EEF4166660640E0F2C755310000005C8F23420AD7334040FCC7555300000047E17142295C8F40A005C85544000000703D61420AD77340F807C8556C000000B89EAC42A470BD40500AC8557C0000005C8FC042D8A3D840A80CC85548000000D7A368421F858340000FC8554200000048E14B420AD77340B013C855BC0000009A5915437B142A410816C85598000000A4F0E04252B80241C021C8553D000000A470484214AE57401824C8554C000000295C7342F6288440C828C855770000006766BC42EB51D040202BC85546000000B81E5C42EC5178408034C85559000000F6A88F420AD79B40E03DC85510000000EC5158410AD7633FD8CCC855800000009042CA427B14DE4038D6C855280100005ECF6643723D8041E8DAC85512000000D7
    A378411F858B3F48E4C85514000000EC51884185EB913FB0F4C855B00000001E850A433D0A1B4108F7C855230000005C8FDE4185EBF13F60F9C855750000005C0FB542AE47C940B8FBC855810000005238CD4214AEDF406800C955D3000000156E2543703D3A411805C9552000000014AEC7415C8FE23F200CC955490000003E0A644200008040780EC955580000005C0F8D42D7A39840D010C955510000007B147C423E0A8F40D817C95563000000ECD1984248E1AA40301AC955500000005C8F6C4200008840B846C95524000000F628D0419A99F93F1049C955B9000000CC0C1143676622412057C955B10000000A970C4366661A417859C95563010000C3359043D7A39C41D05BC95525020000D7E3E343F128F641285EC9552200000014AECD417B14EE3FD862C955720000001E05BC425C8FD2403065C95544010000291C8243E17A8E418867C9556B000000E1FAA04252B8B640E069C9553800000033332D4200004040386CC9554B000000D7A36A42AE478140906EC95556000000285C8242A3709540E870C955B2020000D6F30D4450B81942F87EC95514000000CDCC7841C3F5883FB020CA55840000000AD7D4427A14E640102ACA5539000000D7A336428FC24540682CCA55CB000000285C1943A7702D41C02ECA554500000032335D428DC275401831CA5559000000F628844252B89640C079CA553100000066661C42A4702D40187CCA552A0000001E850A42B71E1540707ECA55300000003D0A1842E7512840C880CA55130000000AD76F415C8F823F2083CA556F000000EC51B342EC51C840F0A3CA5538000000F42837428BC2454048A6CA5523010000000072438FC28541A0A8CA550600000052B88E400AD7A33EA8AFCA5572000000A4F0B04214AEC74000B2CA5567000000A4F0A242F628B44058B4CA55400000009A993D42713D5A40B0B6CA55A4000000ECD1F242E17A104108B9CA55890000007A14D4425C8FF240806DCB5579000000A470BD421F85D340E076CB556E000000EC51A942CDCCBC403879CB55A9000000D7E30643723D1241A890CB55DB000000EA513543E47A404110A1CB55E700000052782F43D0CC4441C0A5CB55160100003E0A5743A4706D4120AFCB5569000000AEC7AA42ED51B84078B1CB55C3000000EA911743BD1E2941D0B3CB55B40000000040114351B81E4128B6CB554B00000052B874421F85834080B8CB55F0000000AE873A43B81E5141E0C1CB55000100000B974943B81E5D4190C6CB55170000005C8F844148E19A3FE8C8CB5537000000C2F533425B8F424040CBCB554C00000014AE7242E17A8440A0D4CB55B6
    00000014EE0C433F0A1B4150D9CB559C0000003533FA42CDCC0841A8DBCB556F0000005C8FAC42AE47C14060E7CB557200000085EBB6426666C640C0F0CB557F00000029DCCC42EC51E04018F3CB5568000000AE47AB429999B940D0FECB55AF000000299C064351B816418003CC5589000000ECD1E342A470F540D805CC556100000052B89642D7A3A84008C6CC55710000003E0AC042AE47C94010CDCC558E0000009899E0429A99F94068CFCC55BC000000852B14437B14224120DBCC559A0000001D85F242C2F5044178DDCC550E0000001F853B4114AE473FD8E6CC55C5000000E1FA1A4366662A4130E9CC5570000000A3F0B442F628C44088EBCC554300000048E149422D336340E0EDCC55B70100000060AA43E37ABC4138F0CC55200000003D0ABF419A99D93F90F2CC55A20000003D8AFC4292C20941E8F4CC5541000000295C4542D8A36040000ACD55190000001F8595411F85AB3F580CCD55A50000002085FC420CD70F41B00ECD55610000000A579F42E17AAC400811CD5539000000703D3E42AD4751406013CD5516000000F6287441E17A943FB815CD554100000014AE4042CDCC5C40C01CCD55A10000007A14FF42EC510C417021CD553500000048E12842999939402026CD5516000000C3F58241E17A943F7828CD55B200000090420A43703D1A41282DCD5554000000295C8C42EC519840802FCD5520000000B81EBD41EC51D83FD831CD557C0000003333C642D7A3D8408836CD557B0000009042C6420AD7DB405050CD55F1000000F5E841434BE152415857CD55870000007D14CF427D14EE40B059CD55E4000000C23533435B8F4A41085CCD55390000007B143A429A994940D812CE5543000000A470544266666640E019CE55F80000001F853F4311D75341381CCE5517000000F6289A415C8FA23F901ECE550D000000CDCC24418FC2353FA02CCE5578000000A1F0B7427E14CE40F82ECE559D000000846BF3425C8F0A415031CE558E0000001E85DB427814F640B03ACE556E01000053189343285C9F41083DCE555A000000ADC782421F859B40603FCE55CE0100006666B9434DB8C841B841CE552B000000666607420AD713406846CE55B300000084AB0F4348E11A412052CE553600000000002F42000040407854CE558F0000000180E242BC1EF540805BCE55210000005C8FCA41AE47E13F3060CE55A6000000142E084392C215418862CE553F00000099993B4200006040608ACE5566000000AEC7A5425C8FB240B88CCE55640000000080A042A470AD407098CE556F0000009A199D4252B8B640C89ACE55790000001E85C542E17AD44020
    9DCE55A500000047210343EC511041789FCE5543000000CDCC4E423D0A6740D0A1CE55CF0000000A571C430AD7334128A4CE551300000033335341A4707D3F989CCF551200000013AE63415C8F823FF09ECF553600000084EB2B424FB83E4050A8CF555800000047E18C42E17A9C40A8AACF556700000070BD9D42CDCCB44060B6CF551F000000C2F5D641AE47E13F10BBCF556A00000066669D428FC2BD4068BDCF552D000000CDCC0D42CDCC1C4020C9CF5594000000E1FAE642CDCC004158FACF55EE000000C3F54743D6A35841B0FCCF554A000000CDCC73426766864008FFCF556500000052389C42A870AD40000100000045B5C8552300000000002A430000824235E60200CD7FCF12F1490200D1FB01001198020022BF02000101000000AC3FD0551027000000000000030C0000004A63C05510270000C4E9C25510270000444AC45510270000F157C4551027000042AAC55510270000393FC75510270000EBC5C85510270000D99EC9551027000037F2CA5510270000B080CD55102700003995CD55102700005CE5CE5510270000
    

    No data? sync req
    025C000000040000000A000000FF040100000008FFCF556500000052389C42A870AD40000100000045B5C8552300000000002A430000824235E60200CD7FCF12F1490200D1FB01001198020022BF0200010100000032EED0551027000000000000
    
    
    byte[] bytes = OpenFitApi.getFitnessSync();
    Log.d(LOG_TAG, OpenFitApi.byteArrayToHexString(bytes));
    bluetoothLeService.write(bytes);
    
    
    GOOD DATA
    pedometer: 3404 steps, 2.59km, 119cal 
    should be: Monday Aug 17 8:34 pm, running, 01:02 time, 0.00 km,0 cal, avg speed, 0.0kmh, max speed, 0.0kmh, avg pace - --km, max pace, - --, avg heart 88bpm, max 93 bpm 
    0267020000040000000D000000
    FF
    04
    1C000000 = 28 Pedometer records
    5807D255 = Monday, August 17, 2015 9:10:00 AM
    A8000000 = 168
    AE070F439A99D140
    1013D255 = Monday, August 17, 2015 10:00:00 AM : 1439830800
    CC000000 = 204
    0AD71743703DE240
    D025D255 = Monday, August 17, 2015 11:20:00 AM : 1439835600
    09010000 = 265
    46E14743F7281441
    E033D255 = Monday, August 17, 2015 12:20:00 PM : 1439839200
    2E010000 = 302
    F6285A43D6A32441
    3836D255
    34000000 = 52
    48E11842B81EE53F
    9038D255
    65010000
    529888439A994541
    E83AD255
    7D000000
    856BB5423D0A8740
    983FD255
    3E000000
    E07A404213AE0740
    F041D255
    64000000
    9042964200006040
    504BD255
    5D000000 =nope 93bpm : 5D HEX
    90428F42D5A35040 
    0050D255
    88000000
    0000D0421E859B40
    6059D255
    4E000000
    CBCC744279142E40
    B85BD255
    7F000000
    0A57BC425C8F8A40
    8075D255
    59000000
    856B8B423D0A4740
    D877D255
    D1000000
    856B2843AE47F940
    887CD255 = Monday, August 17, 2015 5:30:00 PM : 1439857800
    86000000
    9B19D942EC51A040
    9083D255
    48000000
    CDCC4742C3F51840
    E885D255
    29000000
    D7A3E241295CAF3F
    4088D255
    B3000000
    D8230A433833CB40
    A091D255
    8B000000
    1F05D14233339B40 93bpm : 5D HEX
    F893D255
    61000000
    E1FA9C4285EB6140
    5096D255
    4B000000
    B81E5C4266662640
    A898D255
    10000000
    D7A32841CDCC0C3F
    009BD255
    37000000
    7B142B423D0AF73F
    589DD255
    67000000
    5438974232336340
    08A2D255
    06000000
    9A9989403D0A573E
    B8A6D255
    3F000000
    52B836429A990940
    10A9D255 = Monday, August 17, 2015 8:40:00 PM : 1439869200
    39000000
    CCCC3042
    D7A30040
    09
    01000000
    D89FDF3E
    4F010000
    00000000
    00000000
    00000000
    00000000
    04000000
    0C
    01000000
    D7A7D255 = Monday, August 17, 2015 8:34:47 PM : 1439868887
    3E00000000000000 5800000000000000 0153460000000000 0000000000000000 00000000 00 5D00000000000000 000000000001000000 = 88bpm : 58 HEX 93bpm : 5D HEX
    45B5C855 = Your time zone: Monday, August 10, 2015 7:29:25 AM : 1439216965
    2300000000002A430000824235E60200CD7FCF12F1490200D1FB01001198020022BF02000101000000
    A5AAD255 = Monday, August 17, 2015 8:46:45 PM : 1439869605
    1027000000000000
    
    DATA?
    025C000000040000000A000000FF0401000000
    08FFCF55 = time stamp 1439694600 Saturday, August 15, 2015 8:10:00 PM
    6500000052389C42A870AD400001000000
    45B5C855 = time stamp 1439216965 Monday, August 10, 2015 7:29:25 AM
    2300000000002A430000824235E60200CD7FCF12F1490200D1FB01001198020022BF02000101000000
    32EED055 = time stamp 1439755826 Sunday, August 16, 2015 1:10:26 PM
    1027000000000000
    
    
    int i = AbstractNotificationProtocol.EDataType.DATA_TYPE_READ_ACTION.ordinal();
    DataComposer datacomposer = DataComposer.newVariableDataComposer();
    datacomposer.writeByte((byte)i);
    datacomposer.writeLong(mIndex);
    dataByteArray = datacomposer.toByteArray();
    
    
    HEALTH_APP_TYPE_NONE = new <init>("HEALTH_APP_TYPE_NONE", 0);
        HEALTH_APP_TYPE_SLEEP_MONITORING = new <init>("HEALTH_APP_TYPE_SLEEP_MONITORING", 1);
        HEALTH_APP_TYPE_HEART_RATE = new <init>("HEALTH_APP_TYPE_HEART_RATE", 2);
        
          DATA_TYPE_USER_PROFILE = new <init>("DATA_TYPE_USER_PROFILE", 0);
        DATA_TYPE_PEDOMETER_PROFILE = new <init>("DATA_TYPE_PEDOMETER_PROFILE", 1);
        DATA_TYPE_COACHING_PROFILE = new <init>("DATA_TYPE_COACHING_PROFILE", 2);
        DATA_TYPE_PEDO_RESULTRECORD = new <init>("DATA_TYPE_PEDO_RESULTRECORD", 3);
        DATA_TYPE_PEDO_INFO = new <init>("DATA_TYPE_PEDO_INFO", 4);
        DATA_TYPE_SLEEP_RESULTRECORD = new <init>("DATA_TYPE_SLEEP_RESULTRECORD", 5);
        DATA_TYPE_SLEEP_INFO = new <init>("DATA_TYPE_SLEEP_INFO", 6);
        DATA_TYPE_HEARTRATE_RESULTRECORD = new <init>("DATA_TYPE_HEARTRATE_RESULTRECORD", 7);
        DATA_TYPE_COACHING_VARS = new <init>("DATA_TYPE_COACHING_VARS", 8);
        DATA_TYPE_COACHING_EXERCISERESULT = new <init>("DATA_TYPE_COACHING_EXERCISERESULT", 9);
        DATA_TYPE_COACHING_RUNNINGEXERCISE = new <init>("DATA_TYPE_COACHING_RUNNINGEXERCISE", 10);
        DATA_TYPE_COACHING_ENERGYEXERCISE = new <init>("DATA_TYPE_COACHING_ENERGYEXERCISE", 11);
        DATA_TYPE_COACHING_RESULTRECORD = new <init>("DATA_TYPE_COACHING_RESULTRECORD", 12);
        DATA_TYPE_GPS_INFO = new <init>("DATA_TYPE_GPS_INFO", 13);
        STRUCT_TYPE_DASHBOARD_PEDO_RESULT = new <init>("STRUCT_TYPE_DASHBOARD_PEDO_RESULT", 14);
        STRUCT_TYPE_DASHBOARD_COACHING_RESULT = new <init>("STRUCT_TYPE_DASHBOARD_COACHING_RESULT", 15);
        STRUCT_TYPE_DASHBOARD_HRM_RESULT = new <init>("STRUCT_TYPE_DASHBOARD_HRM_RESULT", 16);
        STRUCT_TYPE_DASHBOARD_SLEEP_RESULT = new <init>("STRUCT_TYPE_DASHBOARD_SLEEP_RESULT", 17);
        
        
        RUN = new <init>("RUN", 0);
        WALK = new <init>("WALK", 1);
        CYCLING = new <init>("CYCLING", 2);
        HIKING = new <init>("HIKING", 3);
        
        PSERVICE_ACCUWEATHER = new <init>("PSERVICE_ACCUWEATHER", 0);
        PSERVICE_GOOGLE = new <init>("PSERVICE_GOOGLE", 1);
        PSERVICE_NONE = new <init>("PSERVICE_NONE", 2);
        PSERVICE_WEATHERNEWS = new <init>("PSERVICE_WEATHERNEWS", 3);
        
        DATA_TYPE_HOST_TO_WINGTIP_SYNC_REQUEST = new <init>("DATA_TYPE_HOST_TO_WINGTIP_SYNC_REQUEST", 0);
        DATA_TYPE_HOST_TO_WINGTUP_SYNC_DONE = new <init>("DATA_TYPE_HOST_TO_WINGTUP_SYNC_DONE", 1);
        DATA_TYPE_HOST_TO_WINGTIP_SYNC_DATA = new <init>("DATA_TYPE_HOST_TO_WINGTIP_SYNC_DATA", 2);
        DATA_TYPE_WINGTIP_TO_HOST_SYNC_DONE = new <init>("DATA_TYPE_WINGTIP_TO_HOST_SYNC_DONE", 3);
        DATA_TYPE_WINGTIP_TO_HOST_SYNC_DATA = new <init>("DATA_TYPE_WINGTIP_TO_HOST_SYNC_DATA", 4);
        DATA_TYPE_WINGTIP_TO_HOST_SYNC_REQUEST = new <init>("DATA_TYPE_WINGTIP_TO_HOST_SYNC_REQUEST", 5);
        DATA_TYPE_WINGTIP_TO_HOST_GPS_HIKING_START = new <init>("DATA_TYPE_WINGTIP_TO_HOST_GPS_HIKING_START", 6);
        DATA_TYPE_WINGTIP_TO_HOST_GPS_CYCLING_START = new <init>("DATA_TYPE_WINGTIP_TO_HOST_GPS_CYCLING_START", 7);
        DATA_TYPE_WINGTIP_TO_HOST_GPS_WALKING_START = new <init>("DATA_TYPE_WINGTIP_TO_HOST_GPS_WALKING_START", 8);
        DATA_TYPE_WINGTIP_TO_HOST_GPS_RUNNING_START = new <init>("DATA_TYPE_WINGTIP_TO_HOST_GPS_RUNNING_START", 9);
        DATA_TYPE_WINGTIP_TO_HOST_GPS_END = new <init>("DATA_TYPE_WINGTIP_TO_HOST_GPS_END", 10);
        DATA_TYPE_WINGTIP_TO_HOST_GPS_REQUEST = new <init>("DATA_TYPE_WINGTIP_TO_HOST_GPS_REQUEST", 11);
        DATA_TYPE_HOST_TO_WINGTIP_GPS_READY = new <init>("DATA_TYPE_HOST_TO_WINGTIP_GPS_READY", 12);
        DATA_TYPE_HOST_TO_WINGTIP_GPS_DATA = new <init>("DATA_TYPE_HOST_TO_WINGTIP_GPS_DATA", 13);
        DATA_TYPE_WINGTIP_TO_HOST_GPS_SUBSCRIBE = new <init>("DATA_TYPE_WINGTIP_TO_HOST_GPS_SUBSCRIBE", 14);
        DATA_TYPE_WINGTIP_TO_HOST_GPS_UNSUBSCRIBE = new <init>("DATA_TYPE_WINGTIP_TO_HOST_GPS_UNSUBSCRIBE", 15);
        DATA_TYPE_HOST_TO_WINGTIP_GPS_GPSON = new <init>("DATA_TYPE_HOST_TO_WINGTIP_GPS_GPSON", 16);
        DATA_TYPE_HOST_TO_WINGTIP_GPS_GPSOFF = new <init>("DATA_TYPE_HOST_TO_WINGTIP_GPS_GPSOFF", 17);
        DATA_TYPE_WINGTIP_TO_HOST_GPS_READY = new <init>("DATA_TYPE_WINGTIP_TO_HOST_GPS_READY", 18);
        DATA_TYPE_WINGTIP_TO_HOST_GPS_EXERCISE_START = new <init>("DATA_TYPE_WINGTIP_TO_HOST_GPS_EXERCISE_START", 19);
        DATA_TYPE_HOST_TO_WINGTIP_SET_HEALTH_APP = new <init>("DATA_TYPE_HOST_TO_WINGTIP_SET_HEALTH_APP", 20);
        DATA_TYPE_WINGTIP_TO_HOST_SET_HEALTH_APP_DONE = new <init>("DATA_TYPE_WINGTIP_TO_HOST_SET_HEALTH_APP_DONE", 21);
        DATA_TYPE_HOST_TO_WINGTIP_GPS_RESULT = new <init>("DATA_TYPE_HOST_TO_WINGTIP_GPS_RESULT", 22);
        DATA_TYPE_HOST_TO_WINGTIP_DASHBOARD_SYNC_REQUEST = new <init>("DATA_TYPE_HOST_TO_WINGTIP_DASHBOARD_SYNC_REQUEST", 23);
        DATA_TYPE_HOST_TO_WINGTIP_DASHBOARD_SYNC_DATA = new <init>("DATA_TYPE_HOST_TO_WINGTIP_DASHBOARD_SYNC_DATA", 24);
        DATA_TYPE_WINGTIP_TO_HOST_DASHBOARD_SYNC_DATA = new <init>("DATA_TYPE_WINGTIP_TO_HOST_DASHBOARD_SYNC_DATA", 25);
        DATA_TYPE_WINGTIP_TO_HOST_DASHBOARD_SYNC_DONE = new <init>("DATA_TYPE_WINGTIP_TO_HOST_DASHBOARD_SYNC_DONE", 26);
        DATA_TYPE_WINGTIP_TO_HOST_BAROMETER_READY = new <init>("DATA_TYPE_WINGTIP_TO_HOST_BAROMETER_READY", 27);
        DATA_TYPE_HOST_TO_WINGTIP_BAROMETER_ON = new <init>("DATA_TYPE_HOST_TO_WINGTIP_BAROMETER_ON", 28);
        DATA_TYPE_HOST_TO_WINGTIP_BAROMETER_OFF = new <init>("DATA_TYPE_HOST_TO_WINGTIP_BAROMETER_OFF", 29);
        
          public static final int COACHING_PROFILE_TYPE_CYCLING = 11002;
    public static final int COACHING_PROFILE_TYPE_HIKING = 12001;
    public static final int COACHING_PROFILE_TYPE_RUNNING = 14002;
    public static final int COACHING_PROFILE_TYPE_WALKING = 10002;
    
    
    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    find device
    05020000000100 find
    05020000000101 done
    
    clock changed
    01020000000202
    
    change clock
    01020000000a01
    01020000000201

    clock request weather
    01010000000C
    
    clock change response?
    013d0000000914fffe4e006900650064006500720072006100640006400600000100c944e0550698080000140500000600000000000000000600000000000000000001020000000200
    013d0000000914fffe4e006900650064006500720072006100640006400600000100c944e05506980800001405000006000000000000000006000000000000000000
    013d0000000914fffe4e006900650064006500720072006100640006d41700000000c944e05506201c00007c15000006000000000000000006000000000000000000
    
    bytes = OpenFitApi.getOpenWeatherClock();
    bluetoothLeService.write(bytes);
    
    view msg
    030900000013F87CCD5500000000
    
    view in phone
    030900000017F87CCD5500000000
    
    quick reply with "Ok"
    030A0000001905F87CCD5500000000
    
    delete notification?
    030900000016CFBCCF5500000000
    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    
    
    WEATHER
        public byte[] createWeatherNotificationProtocol(int i, long l, String s, int j)
    {
        DataComposer datacomposer = DataComposer.newVariableDataComposer();
        datacomposer.writeByte((byte)i);
        datacomposer.writeLong(l);
        if (s == null)
        {
            s = "";
        }
        byte abyte0[] = DataComposer.convertToByteArray(s);
        datacomposer.writeByte((byte)abyte0.length);
        datacomposer.writeBytes(abyte0);
        datacomposer.writeInt(j);
        DataComposer.writeCurrentTimeInfo(datacomposer);
        return datacomposer.toByteArray();
    }
    
        public static final byte PORT_CM = 99;
    public static final byte PORT_CM_FEATURE = 100;
    public static final byte PORT_CUP = 66;
    public static final byte PORT_FEATURE = 0;
    public static final byte PORT_FOTA = 77;
    public static final byte PORT_FOTA_COMMAND = 78;
    public static final byte PORT_REQUEST_READ_RSSI = 44;
    public static final byte PORT_RSSI = 127;
    public static final byte PORT_SENSOR = 8;

    public static byte DATA_TYPE_INCOMING_CALL = 0;
    public static byte DATA_TYPE_MISSCALL = 1;
    public static byte DATA_TYPE_EMAIL = 3;
    public static byte DATA_TYPE_MESSAGE = 4;
    public static byte DATA_TYPE_ALARM = 5;
    public static byte DATA_TYPE_WEATHER = 7;
    public static byte DATA_TYPE_CHATON = 10;
    public static byte DATA_TYPE_GENERAL= 12;
    public static byte DATA_TYPE_REJECT_ACTION = 13;
    public static byte DATA_TYPE_ALARM_ACTION = 14;
    public static byte DATA_TYPE_SMART_RELAY_REQUEST = 17;
    public static byte DATA_TYPE_SMART_RELAY_RESPONSE = 18;
    public static byte DATA_TYPE_IMAGE = 33;
    public static byte DATA_TYPE_CMAS = 35;
    public static byte DATA_TYPE_EAS = 36;
    public static byte DATA_TYPE_RESERVED = 49;

    // Media Controller
    public static final byte FORWARD = 4;
    public static final byte FORWARD_RELEASE = 6;
    public static final byte OPEN = 0;
    public static final byte PAUSE = 2;
    public static final byte PLAY = 1;
    public static final byte REWIND = 5;
    public static final byte REWIND_RELEASE = 7;
    public static final byte STOP = 3;

    public static final byte CONTROL = 0;
    public static final byte INFO = 2;
    public static final byte REQUEST_START = 3;
    public static final byte REQUEST_STOP = 4;
    public static final byte VOLUME = 1;

    // Status Data Type
    public static final byte ALL_INFO = 2;
    public static final byte AUTO_LOCK = 3;
    public static final byte BATTERY_STATUS = 11;
    public static final byte CLOCK_TYPE_ORDER = 16;
    public static final byte DISPLAY_TYPE = 24;
    public static final byte DOUBLE_PRESS_LAUNCH_APP_TYPE = 21;
    public static final byte FONT_SIZE = 9;
    public static final byte FOTA = 14;
    public static final byte HOME_BG_COLOR = 7;
    public static final byte HOME_BG_GALLERY = 15;
    public static final byte HOME_BG_WALLPAPER = 8;
    public static final byte HOME_LAYOUT_ORDER = 18;
    public static final byte LANGUAGE = 10;
    public static final byte LANGUAGE_RESOURCE = 20;
    public static final byte LANGUAGE_RESOURCE_REQUEST = 19;
    public static final byte OPEN_SOURCE_GUIDE_TYPE = 22;
    public static final byte REQUEST_ALL_INFO = 1;
    public static final byte SCREEN_TIMEOUT = 6;
    public static final byte SHAKE_TO_CONTROL = 17;
    public static final byte SMART_RELAY = 4;
    public static final byte SMART_RELAY_CURRENT_DISPLAY = 12;
    public static final byte SOS = 13;
    public static final byte WAKEUP_BY_GESTURE = 5;
    public static final byte WINGTIP_DEVICE_INFO = 23;
    public static final byte WINGTIP_VERSION = 0;

    // Unknown Data Type
    public static final byte OPENFIT_DATA = 100;

    // Byte Type
    static final ByteOrder BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
    static final Charset DEFAULT_CHARSET = Charset.forName("UCS-2");
    static final Charset DEFAULT_DECODING_CHARSET = Charset.forName("US-ASCII");
    public static final int MAX_UNSIGNED_BYTE_VALUE = 255;
    public static final int SIZE_OF_DOUBLE = 8;
    public static final int SIZE_OF_FLOAT = 4;
    public static final int SIZE_OF_INT = 4;
    public static final int SIZE_OF_LONG = 8;
    public static final int SIZE_OF_SHORT = 2;

    // Font Type
    public static final byte TYPE_FONT_LARGE = 2;
    public static final byte TYPE_FONT_NORMAL = 1;
    public static final byte TYPE_FONT_SMALL = 0;

    // HOME BG Type
    public static final int TYPE_HOME_BG_TY_COLOR = 0;
    public static final int TYPE_HOME_BG_IMAGE = 2;
    public static final int TYPE_HOME_BG_WALLPAPER = 1;

    // Unknown Data
    public static final int DISCONNECTED_BY_ACL_DISCONNECTED = 2;
    public static final int DISCONNECTED_BY_SOCKET_CLOSED = 1;
    public static final int DISCONNECTED_BY_TIMEOUT = 3;

    public static final int MSG_ID_CONNECTED = 2;
    public static final int MSG_ID_DATA_RECEIVED = 5;
    public static final int MSG_ID_DISCONNECTED = 3;
    public static final int MSG_ID_ETC_DATA_RECEIVED = 6;

    public static final byte LAUNCHER_APP_TYPE_CLOCK = 1;
    public static final byte LAUNCHER_APP_TYPE_CUIP = 0;
    public static final byte LAUNCHER_APP_TYPE_EXERCISE = 6;
    public static final byte LAUNCHER_APP_TYPE_FIND_MY_DEIVCE = 4;
    public static final byte LAUNCHER_APP_TYPE_HEARTRATE = 7;
    public static final byte LAUNCHER_APP_TYPE_MAX = 12;
    public static final byte LAUNCHER_APP_TYPE_MEDIA_CONTROLLER = 3;
    public static final byte LAUNCHER_APP_TYPE_NOTIFICATIONS = 2;
    public static final byte LAUNCHER_APP_TYPE_PEDOMETER = 5;
    public static final byte LAUNCHER_APP_TYPE_SETTINGS = 10;
    public static final byte LAUNCHER_APP_TYPE_SLEEP = 11;
    public static final byte LAUNCHER_APP_TYPE_STOP_WATCH = 9;
    public static final byte LAUNCHER_APP_TYPE_TIMER = 8;

    public static final byte TEXT_DATE_FORMAT_TYPE = 1; // 0,1,2
    public static final byte NUMBER_DATE_FORMAT_TYPE = 2; // 0,1,2
    public static final boolean IS_TIME_DISPLAY_24 = false; // 0,1

*/
