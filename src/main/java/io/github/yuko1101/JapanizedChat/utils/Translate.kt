package io.github.yuko1101.JapanizedChat.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;

import net.minecraft.util.EnumChatFormatting;

public class Translate implements Runnable {
    String str;
    String mode;
    //private static final String SOCIAL_IME_URL = "http://www.social-ime.com/api/?string=";
    //private static final String GOOGLE_IME_URL = "http://www.google.com/transliterate?langpair=ja-Hira|ja&text=";

    public Translate(String msg, String mode) {
        this.str = msg;
        this.mode = mode;
    }

    public static String toKana(String msg) {
        msg = msg.replaceAll("nn", "ん");
        msg = msg.replaceAll("wwha", "っうぁ");
        msg = msg.replaceAll("wwhi", "っうぃ");
        msg = msg.replaceAll("wwhu", "っう");
        msg = msg.replaceAll("wwhe", "っうぇ");
        msg = msg.replaceAll("wwho", "っうぉ");
        msg = msg.replaceAll("wwyi", "っゐ");
        msg = msg.replaceAll("wwye", "っゑ");
        msg = msg.replaceAll("xxa", "っぁ");
        msg = msg.replaceAll("xxi", "っぃ");
        msg = msg.replaceAll("xxu", "っぅ");
        msg = msg.replaceAll("xxe", "っぇ");
        msg = msg.replaceAll("xxo", "っぉ");
        msg = msg.replaceAll("xxya", "っゃ");
        msg = msg.replaceAll("xxyu", "っゅ");
        msg = msg.replaceAll("xxyo", "っょ");
        msg = msg.replaceAll("xxtu", "っっ");
        msg = msg.replaceAll("lla", "っぁ");
        msg = msg.replaceAll("lli", "っぃ");
        msg = msg.replaceAll("llu", "っぅ");
        msg = msg.replaceAll("lle", "っぇ");
        msg = msg.replaceAll("llo", "っぉ");
        msg = msg.replaceAll("llya", "っゃ");
        msg = msg.replaceAll("llyu", "っゅ");
        msg = msg.replaceAll("llyo", "っょ");
        msg = msg.replaceAll("lltu", "っっ");
        msg = msg.replaceAll("kka", "っか");
        msg = msg.replaceAll("kki", "っき");
        msg = msg.replaceAll("kku", "っく");
        msg = msg.replaceAll("kke", "っけ");
        msg = msg.replaceAll("kko", "っこ");
        msg = msg.replaceAll("kkya", "っきゃ");
        msg = msg.replaceAll("kkyi", "っきぃ");
        msg = msg.replaceAll("kkyu", "っきゅ");
        msg = msg.replaceAll("kkye", "っきぇ");
        msg = msg.replaceAll("kkyo", "っきょ");
        msg = msg.replaceAll("gga", "っが");
        msg = msg.replaceAll("ggi", "っぎ");
        msg = msg.replaceAll("ggu", "っぐ");
        msg = msg.replaceAll("gge", "っげ");
        msg = msg.replaceAll("ggo", "っご");
        msg = msg.replaceAll("ggya", "っぎゃ");
        msg = msg.replaceAll("ggyi", "っぎぃ");
        msg = msg.replaceAll("ggyu", "っぎゅ");
        msg = msg.replaceAll("ggye", "っぎぇ");
        msg = msg.replaceAll("ggyo", "っぎょ");
        msg = msg.replaceAll("ttsa", "っつぁ");
        msg = msg.replaceAll("ttsi", "っつぃ");
        msg = msg.replaceAll("ttsu", "っつ");
        msg = msg.replaceAll("ttse", "っつぇ");
        msg = msg.replaceAll("ttso", "っつぉ");
        msg = msg.replaceAll("ssa", "っさ");
        msg = msg.replaceAll("ssi", "っし");
        msg = msg.replaceAll("ssu", "っす");
        msg = msg.replaceAll("sse", "っせ");
        msg = msg.replaceAll("sso", "っそ");
        msg = msg.replaceAll("cca", "っか");
        msg = msg.replaceAll("cci", "っし");
        msg = msg.replaceAll("ccu", "っく");
        msg = msg.replaceAll("cce", "っせ");
        msg = msg.replaceAll("cco", "っこ");
        msg = msg.replaceAll("ssha", "っしゃ");
        msg = msg.replaceAll("sshi", "っし");
        msg = msg.replaceAll("sshu", "っしゅ");
        msg = msg.replaceAll("sshe", "っしぇ");
        msg = msg.replaceAll("ssho", "っしょ");
        msg = msg.replaceAll("ssya", "っしゃ");
        msg = msg.replaceAll("ssyi", "っしぃ");
        msg = msg.replaceAll("ssyu", "っしゅ");
        msg = msg.replaceAll("ssye", "っしぇ");
        msg = msg.replaceAll("ssyo", "っしょ");
        msg = msg.replaceAll("zza", "っざ");
        msg = msg.replaceAll("zzi", "っじ");
        msg = msg.replaceAll("zzu", "っず");
        msg = msg.replaceAll("zze", "っぜ");
        msg = msg.replaceAll("zzo", "っぞ");
        msg = msg.replaceAll("jja", "っじゃ");
        msg = msg.replaceAll("jji", "っじ");
        msg = msg.replaceAll("jju", "っじゅ");
        msg = msg.replaceAll("jje", "っじぇ");
        msg = msg.replaceAll("jjo", "っじょ");
        msg = msg.replaceAll("jjya", "っじゃ");
        msg = msg.replaceAll("jjyi", "っじぃ");
        msg = msg.replaceAll("jjyu", "っじゅ");
        msg = msg.replaceAll("jjye", "っじぇ");
        msg = msg.replaceAll("jjyo", "っじょ");
        msg = msg.replaceAll("zzya", "っじゃ");
        msg = msg.replaceAll("zzyi", "っじぃ");
        msg = msg.replaceAll("zzyu", "っじゅ");
        msg = msg.replaceAll("zzye", "っじぇ");
        msg = msg.replaceAll("zzyo", "っじょ");
        msg = msg.replaceAll("tta", "った");
        msg = msg.replaceAll("tti", "っち");
        msg = msg.replaceAll("ttu", "っつ");
        msg = msg.replaceAll("tte", "って");
        msg = msg.replaceAll("tto", "っと");
        msg = msg.replaceAll("ttya", "っちゃ");
        msg = msg.replaceAll("ttyi", "っちぃ");
        msg = msg.replaceAll("ttyu", "っちゅ");
        msg = msg.replaceAll("ttye", "っちぇ");
        msg = msg.replaceAll("ttyo", "っちょ");
        msg = msg.replaceAll("ttha", "ってゃ");
        msg = msg.replaceAll("tthi", "ってぃ");
        msg = msg.replaceAll("tthu", "ってゅ");
        msg = msg.replaceAll("tthe", "ってぇ");
        msg = msg.replaceAll("ttho", "ってょ");
        msg = msg.replaceAll("ccya", "っちゃ");
        msg = msg.replaceAll("ccyi", "っちぃ");
        msg = msg.replaceAll("ccyu", "っちゅ");
        msg = msg.replaceAll("ccye", "っちぇ");
        msg = msg.replaceAll("ccyo", "っちょ");
        msg = msg.replaceAll("ccha", "っちゃ");
        msg = msg.replaceAll("cchi", "っち");
        msg = msg.replaceAll("cchu", "っちゅ");
        msg = msg.replaceAll("cche", "っちぇ");
        msg = msg.replaceAll("ccho", "っちょ");
        msg = msg.replaceAll("dda", "っだ");
        msg = msg.replaceAll("ddi", "っぢ");
        msg = msg.replaceAll("ddu", "っづ");
        msg = msg.replaceAll("dde", "っで");
        msg = msg.replaceAll("ddo", "っど");
        msg = msg.replaceAll("ddya", "っぢゃ");
        msg = msg.replaceAll("ddyi", "っぢぃ");
        msg = msg.replaceAll("ddyu", "っぢゅ");
        msg = msg.replaceAll("ddye", "っぢぇ");
        msg = msg.replaceAll("ddyo", "っぢょ");
        msg = msg.replaceAll("ddha", "っでゃ");
        msg = msg.replaceAll("ddhi", "っでぃ");
        msg = msg.replaceAll("ddhu", "っでゅ");
        msg = msg.replaceAll("ddhe", "っでぇ");
        msg = msg.replaceAll("ddho", "っでょ");
        msg = msg.replaceAll("ppha", "っふぁ");
        msg = msg.replaceAll("pphi", "っふぃ");
        msg = msg.replaceAll("pphu", "っふ");
        msg = msg.replaceAll("pphe", "っふぇ");
        msg = msg.replaceAll("ppho", "っふぉ");
        msg = msg.replaceAll("hha", "っは");
        msg = msg.replaceAll("hhi", "っひ");
        msg = msg.replaceAll("hhu", "っふ");
        msg = msg.replaceAll("hhe", "っへ");
        msg = msg.replaceAll("hho", "っほ");
        msg = msg.replaceAll("hhya", "っひゃ");
        msg = msg.replaceAll("hhyi", "っひぃ");
        msg = msg.replaceAll("hhyu", "っひゅ");
        msg = msg.replaceAll("hhye", "っひぇ");
        msg = msg.replaceAll("hhyo", "っひょ");
        msg = msg.replaceAll("ffa", "っふぁ");
        msg = msg.replaceAll("ffi", "っふぃ");
        msg = msg.replaceAll("ffu", "っふ");
        msg = msg.replaceAll("ffe", "っふぇ");
        msg = msg.replaceAll("ffo", "っふぉ");
        msg = msg.replaceAll("ppa", "っぱ");
        msg = msg.replaceAll("ppi", "っぴ");
        msg = msg.replaceAll("ppu", "っぷ");
        msg = msg.replaceAll("ppe", "っぺ");
        msg = msg.replaceAll("ppo", "っぽ");
        msg = msg.replaceAll("ppya", "っぴゃ");
        msg = msg.replaceAll("ppyi", "っぴぃ");
        msg = msg.replaceAll("ppyu", "っぴゅ");
        msg = msg.replaceAll("ppye", "っぴぇ");
        msg = msg.replaceAll("ppyo", "っぴょ");
        msg = msg.replaceAll("bba", "っば");
        msg = msg.replaceAll("bbi", "っび");
        msg = msg.replaceAll("bbu", "っぶ");
        msg = msg.replaceAll("bbe", "っべ");
        msg = msg.replaceAll("bbo", "っぼ");
        msg = msg.replaceAll("bbya", "っびゃ");
        msg = msg.replaceAll("bbyi", "っびぃ");
        msg = msg.replaceAll("bbyu", "っびゅ");
        msg = msg.replaceAll("bbye", "っびぇ");
        msg = msg.replaceAll("bbyo", "っびょ");
        msg = msg.replaceAll("vva", "っヴァ");
        msg = msg.replaceAll("vvi", "っヴィ");
        msg = msg.replaceAll("vvu", "っヴ");
        msg = msg.replaceAll("vve", "っヴェ");
        msg = msg.replaceAll("vvo", "っヴォ");
        msg = msg.replaceAll("vvya", "っヴャ");
        msg = msg.replaceAll("vvyu", "っヴュ");
        msg = msg.replaceAll("vvyo", "っヴョ");
        msg = msg.replaceAll("mma", "っま");
        msg = msg.replaceAll("mmi", "っみ");
        msg = msg.replaceAll("mmu", "っむ");
        msg = msg.replaceAll("mme", "っめ");
        msg = msg.replaceAll("mmo", "っも");
        msg = msg.replaceAll("mmya", "っみゃ");
        msg = msg.replaceAll("mmyi", "っみぃ");
        msg = msg.replaceAll("mmyu", "っみゅ");
        msg = msg.replaceAll("mmye", "っみぇ");
        msg = msg.replaceAll("mmyo", "っみょ");
        msg = msg.replaceAll("rrya", "っりゃ");
        msg = msg.replaceAll("rryi", "っりぃ");
        msg = msg.replaceAll("rryu", "っりゅ");
        msg = msg.replaceAll("rrye", "っりぇ");
        msg = msg.replaceAll("rryo", "っりょ");
        msg = msg.replaceAll("yya", "っや");
        msg = msg.replaceAll("yyu", "っゆ");
        msg = msg.replaceAll("yye", "っいぇ");
        msg = msg.replaceAll("yyo", "っよ");
        msg = msg.replaceAll("rra", "っら");
        msg = msg.replaceAll("rri", "っり");
        msg = msg.replaceAll("rru", "っる");
        msg = msg.replaceAll("rre", "っれ");
        msg = msg.replaceAll("rro", "っろ");
        msg = msg.replaceAll("wwa", "っわ");
        msg = msg.replaceAll("wwi", "っうぃ");
        msg = msg.replaceAll("wwu", "っう");
        msg = msg.replaceAll("wwe", "っうぇ");
        msg = msg.replaceAll("wwo", "っを");
        msg = msg.replaceAll("wha", "うぁ");
        msg = msg.replaceAll("whi", "うぃ");
        msg = msg.replaceAll("whu", "う");
        msg = msg.replaceAll("whe", "うぇ");
        msg = msg.replaceAll("who", "うぉ");
        msg = msg.replaceAll("wyi", "ゐ");
        msg = msg.replaceAll("wye", "ゑ");
        msg = msg.replaceAll("xa", "ぁ");
        msg = msg.replaceAll("xi", "ぃ");
        msg = msg.replaceAll("xu", "ぅ");
        msg = msg.replaceAll("xe", "ぇ");
        msg = msg.replaceAll("xo", "ぉ");
        msg = msg.replaceAll("xya", "ゃ");
        msg = msg.replaceAll("xyu", "ゅ");
        msg = msg.replaceAll("xyo", "ょ");
        msg = msg.replaceAll("xtu", "っ");
        msg = msg.replaceAll("la", "ぁ");
        msg = msg.replaceAll("li", "ぃ");
        msg = msg.replaceAll("lu", "ぅ");
        msg = msg.replaceAll("le", "ぇ");
        msg = msg.replaceAll("lo", "ぉ");
        msg = msg.replaceAll("lya", "ゃ");
        msg = msg.replaceAll("lyu", "ゅ");
        msg = msg.replaceAll("lyo", "ょ");
        msg = msg.replaceAll("ltu", "っ");
        msg = msg.replaceAll("ka", "か");
        msg = msg.replaceAll("ki", "き");
        msg = msg.replaceAll("ku", "く");
        msg = msg.replaceAll("ke", "け");
        msg = msg.replaceAll("ko", "こ");
        msg = msg.replaceAll("kya", "きゃ");
        msg = msg.replaceAll("kyi", "きぃ");
        msg = msg.replaceAll("kyu", "きゅ");
        msg = msg.replaceAll("kye", "きぇ");
        msg = msg.replaceAll("kyo", "きょ");
        msg = msg.replaceAll("ga", "が");
        msg = msg.replaceAll("gi", "ぎ");
        msg = msg.replaceAll("gu", "ぐ");
        msg = msg.replaceAll("ge", "げ");
        msg = msg.replaceAll("go", "ご");
        msg = msg.replaceAll("gya", "ぎゃ");
        msg = msg.replaceAll("gyi", "ぎぃ");
        msg = msg.replaceAll("gyu", "ぎゅ");
        msg = msg.replaceAll("gye", "ぎぇ");
        msg = msg.replaceAll("gyo", "ぎょ");
        msg = msg.replaceAll("tsa", "つぁ");
        msg = msg.replaceAll("tsi", "つぃ");
        msg = msg.replaceAll("tsu", "つ");
        msg = msg.replaceAll("tse", "つぇ");
        msg = msg.replaceAll("tso", "つぉ");
        msg = msg.replaceAll("sa", "さ");
        msg = msg.replaceAll("si", "し");
        msg = msg.replaceAll("su", "す");
        msg = msg.replaceAll("se", "せ");
        msg = msg.replaceAll("so", "そ");
        msg = msg.replaceAll("ca", "か");
        msg = msg.replaceAll("ci", "し");
        msg = msg.replaceAll("cu", "く");
        msg = msg.replaceAll("ce", "せ");
        msg = msg.replaceAll("co", "こ");
        msg = msg.replaceAll("sha", "しゃ");
        msg = msg.replaceAll("shi", "し");
        msg = msg.replaceAll("shu", "しゅ");
        msg = msg.replaceAll("she", "しぇ");
        msg = msg.replaceAll("sho", "しょ");
        msg = msg.replaceAll("sya", "しゃ");
        msg = msg.replaceAll("syi", "しぃ");
        msg = msg.replaceAll("syu", "しゅ");
        msg = msg.replaceAll("sye", "しぇ");
        msg = msg.replaceAll("syo", "しょ");
        msg = msg.replaceAll("za", "ざ");
        msg = msg.replaceAll("zi", "じ");
        msg = msg.replaceAll("zu", "ず");
        msg = msg.replaceAll("ze", "ぜ");
        msg = msg.replaceAll("zo", "ぞ");
        msg = msg.replaceAll("ja", "じゃ");
        msg = msg.replaceAll("ji", "じ");
        msg = msg.replaceAll("ju", "じゅ");
        msg = msg.replaceAll("je", "じぇ");
        msg = msg.replaceAll("jo", "じょ");
        msg = msg.replaceAll("jya", "じゃ");
        msg = msg.replaceAll("jyi", "じぃ");
        msg = msg.replaceAll("jyu", "じゅ");
        msg = msg.replaceAll("jye", "じぇ");
        msg = msg.replaceAll("jyo", "じょ");
        msg = msg.replaceAll("zya", "じゃ");
        msg = msg.replaceAll("zyi", "じぃ");
        msg = msg.replaceAll("zyu", "じゅ");
        msg = msg.replaceAll("zye", "じぇ");
        msg = msg.replaceAll("zyo", "じょ");
        msg = msg.replaceAll("ta", "た");
        msg = msg.replaceAll("ti", "ち");
        msg = msg.replaceAll("tu", "つ");
        msg = msg.replaceAll("te", "て");
        msg = msg.replaceAll("to", "と");
        msg = msg.replaceAll("tya", "ちゃ");
        msg = msg.replaceAll("tyi", "ちぃ");
        msg = msg.replaceAll("tyu", "ちゅ");
        msg = msg.replaceAll("tye", "ちぇ");
        msg = msg.replaceAll("tyo", "ちょ");
        msg = msg.replaceAll("tha", "てゃ");
        msg = msg.replaceAll("thi", "てぃ");
        msg = msg.replaceAll("thu", "てゅ");
        msg = msg.replaceAll("the", "てぇ");
        msg = msg.replaceAll("tho", "てょ");
        msg = msg.replaceAll("cya", "ちゃ");
        msg = msg.replaceAll("cyi", "ちぃ");
        msg = msg.replaceAll("cyu", "ちゅ");
        msg = msg.replaceAll("cye", "ちぇ");
        msg = msg.replaceAll("cyo", "ちょ");
        msg = msg.replaceAll("cha", "ちゃ");
        msg = msg.replaceAll("chi", "ち");
        msg = msg.replaceAll("chu", "ちゅ");
        msg = msg.replaceAll("che", "ちぇ");
        msg = msg.replaceAll("cho", "ちょ");
        msg = msg.replaceAll("da", "だ");
        msg = msg.replaceAll("di", "ぢ");
        msg = msg.replaceAll("du", "づ");
        msg = msg.replaceAll("de", "で");
        msg = msg.replaceAll("do", "ど");
        msg = msg.replaceAll("dya", "ぢゃ");
        msg = msg.replaceAll("dyi", "ぢぃ");
        msg = msg.replaceAll("dyu", "ぢゅ");
        msg = msg.replaceAll("dye", "ぢぇ");
        msg = msg.replaceAll("dyo", "ぢょ");
        msg = msg.replaceAll("dha", "でゃ");
        msg = msg.replaceAll("dhi", "でぃ");
        msg = msg.replaceAll("dhu", "でゅ");
        msg = msg.replaceAll("dhe", "でぇ");
        msg = msg.replaceAll("dho", "でょ");
        msg = msg.replaceAll("na", "な");
        msg = msg.replaceAll("ni", "に");
        msg = msg.replaceAll("nu", "ぬ");
        msg = msg.replaceAll("ne", "ね");
        msg = msg.replaceAll("no", "の");
        msg = msg.replaceAll("nya", "にゃ");
        msg = msg.replaceAll("nyi", "にぃ");
        msg = msg.replaceAll("nyu", "にゅ");
        msg = msg.replaceAll("nye", "にぇ");
        msg = msg.replaceAll("nyo", "にょ");
        msg = msg.replaceAll("pha", "ふぁ");
        msg = msg.replaceAll("phi", "ふぃ");
        msg = msg.replaceAll("phu", "ふ");
        msg = msg.replaceAll("phe", "ふぇ");
        msg = msg.replaceAll("pho", "ふぉ");
        msg = msg.replaceAll("ha", "は");
        msg = msg.replaceAll("hi", "ひ");
        msg = msg.replaceAll("hu", "ふ");
        msg = msg.replaceAll("he", "へ");
        msg = msg.replaceAll("ho", "ほ");
        msg = msg.replaceAll("hya", "ひゃ");
        msg = msg.replaceAll("hyi", "ひぃ");
        msg = msg.replaceAll("hyu", "ひゅ");
        msg = msg.replaceAll("hye", "ひぇ");
        msg = msg.replaceAll("hyo", "ひょ");
        msg = msg.replaceAll("fa", "ふぁ");
        msg = msg.replaceAll("fi", "ふぃ");
        msg = msg.replaceAll("fu", "ふ");
        msg = msg.replaceAll("fe", "ふぇ");
        msg = msg.replaceAll("fo", "ふぉ");
        msg = msg.replaceAll("fya", "ふゃ");
        msg = msg.replaceAll("fyi", "ふぃ");
        msg = msg.replaceAll("fyu", "ふゅ");
        msg = msg.replaceAll("fye", "ふぇ");
        msg = msg.replaceAll("fyo", "ふょ");
        msg = msg.replaceAll("pa", "ぱ");
        msg = msg.replaceAll("pi", "ぴ");
        msg = msg.replaceAll("pu", "ぷ");
        msg = msg.replaceAll("pe", "ぺ");
        msg = msg.replaceAll("po", "ぽ");
        msg = msg.replaceAll("pya", "ぴゃ");
        msg = msg.replaceAll("pyi", "ぴぃ");
        msg = msg.replaceAll("pyu", "ぴゅ");
        msg = msg.replaceAll("pye", "ぴぇ");
        msg = msg.replaceAll("pyo", "ぴょ");
        msg = msg.replaceAll("ba", "ば");
        msg = msg.replaceAll("bi", "び");
        msg = msg.replaceAll("bu", "ぶ");
        msg = msg.replaceAll("be", "べ");
        msg = msg.replaceAll("bo", "ぼ");
        msg = msg.replaceAll("bya", "びゃ");
        msg = msg.replaceAll("byi", "びぃ");
        msg = msg.replaceAll("byu", "びゅ");
        msg = msg.replaceAll("bye", "びぇ");
        msg = msg.replaceAll("byo", "びょ");
        msg = msg.replaceAll("va", "ヴァ");
        msg = msg.replaceAll("vi", "ヴィ");
        msg = msg.replaceAll("vu", "ヴ");
        msg = msg.replaceAll("ve", "ヴェ");
        msg = msg.replaceAll("vo", "ヴォ");
        msg = msg.replaceAll("vya", "ヴャ");
        msg = msg.replaceAll("vyu", "ヴュ");
        msg = msg.replaceAll("vyo", "ヴョ");
        msg = msg.replaceAll("ma", "ま");
        msg = msg.replaceAll("mi", "み");
        msg = msg.replaceAll("mu", "む");
        msg = msg.replaceAll("me", "め");
        msg = msg.replaceAll("mo", "も");
        msg = msg.replaceAll("mya", "みゃ");
        msg = msg.replaceAll("myi", "みぃ");
        msg = msg.replaceAll("myu", "みゅ");
        msg = msg.replaceAll("mye", "みぇ");
        msg = msg.replaceAll("myo", "みょ");
        msg = msg.replaceAll("rya", "りゃ");
        msg = msg.replaceAll("ryi", "りぃ");
        msg = msg.replaceAll("ryu", "りゅ");
        msg = msg.replaceAll("rye", "りぇ");
        msg = msg.replaceAll("ryo", "りょ");
        msg = msg.replaceAll("ya", "や");
        msg = msg.replaceAll("yu", "ゆ");
        msg = msg.replaceAll("ye", "いぇ");
        msg = msg.replaceAll("yo", "よ");
        msg = msg.replaceAll("ra", "ら");
        msg = msg.replaceAll("ri", "り");
        msg = msg.replaceAll("ru", "る");
        msg = msg.replaceAll("re", "れ");
        msg = msg.replaceAll("ro", "ろ");
        msg = msg.replaceAll("wa", "わ");
        msg = msg.replaceAll("wi", "うぃ");
        msg = msg.replaceAll("wu", "う");
        msg = msg.replaceAll("we", "うぇ");
        msg = msg.replaceAll("wo", "を");
        msg = msg.replaceAll("a", "あ");
        msg = msg.replaceAll("i", "い");
        msg = msg.replaceAll("u", "う");
        msg = msg.replaceAll("e", "え");
        msg = msg.replaceAll("o", "お");
        msg = msg.replaceAll("n", "ん");
        msg = msg.replaceAll("!", "！");
        msg = msg.replaceAll("\\?", "？");
        msg = msg.replaceAll("~", "～");
        msg = msg.replaceAll("-", "ー");
        msg = msg.replaceAll("\\[", "「");
        msg = msg.replaceAll("]", "」");
        msg = msg.replaceAll(",", "、");
        return msg;
    }

    public static String convByGoogleIME(String org) {
        return conv(org, true);
    }

    /** @deprecated */
    @Deprecated
    public static String convBySocialIME(String org) {
        return conv(org, false);
    }

    private static String conv(String org, boolean isGoogleIME) {
        if (org.length() != 0) {
            HttpURLConnection urlconn = null;
            BufferedReader reader = null;

            try {
                String baseurl;
                String encode;
                if (isGoogleIME) {
                    baseurl = "http://www.google.com/transliterate?langpair=ja-Hira|ja&text=" + URLEncoder.encode(org, "UTF-8");
                    encode = "UTF-8";
                } else {
                    baseurl = "http://www.social-ime.com/api/?string=" + URLEncoder.encode(org, "UTF-8");
                    encode = "EUC_JP";
                }

                URL url = new URL(baseurl);
                urlconn = (HttpURLConnection) url.openConnection();
                urlconn.setRequestMethod("GET");
                urlconn.setInstanceFollowRedirects(false);
                urlconn.connect();
                reader = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), encode));
                String line;
                StringBuilder result = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    if (isGoogleIME) {
                        result.append(parseGoogleIMEResult(line));
                    } else {
                        result.append(pickFirstElement(line));
                    }
                }

                return result.toString();
            } catch (IOException var24) {
                var24.printStackTrace();
            } finally {
                if (urlconn != null) {
                    urlconn.disconnect();
                }

                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException ignored) {
                    }
                }

            }

        }
        return "";
    }

    private static String pickFirstElement(String org) {
        int index = org.indexOf("\t");
        return index == -1 ? org : org.substring(0, index);
    }

    private static String parseGoogleIMEResult(String result) {
        StringBuilder buf = new StringBuilder();
        int level = 0;
        int index = 0;

        while(index < result.length()) {
            int nextStart;
            int nextEnd;
            if (level >= 3) {
                nextStart = result.indexOf("\"", index);
                nextEnd = result.indexOf("\"", nextStart + 1);
                if (nextStart == -1 || nextEnd == -1) {
                    return buf.toString();
                }

                buf.append(result, nextStart + 1, nextEnd);
                int next = result.indexOf("]", nextEnd);
                if (next == -1) {
                    return buf.toString();
                }

                --level;
                index = next + 1;
            } else {
                nextStart = result.indexOf("[", index);
                nextEnd = result.indexOf("]", index);
                if (nextStart == -1) {
                    return buf.toString();
                }

                if (nextStart < nextEnd) {
                    ++level;
                    index = nextStart + 1;
                } else {
                    --level;
                    index = nextEnd + 1;
                }
            }
        }

        return buf.toString();
    }

    private void sendChat(String text) {
        String[] s = text.split(EnumChatFormatting.WHITE + ": " + EnumChatFormatting.RESET);
        String msg = String.join(EnumChatFormatting.WHITE + ": " + EnumChatFormatting.RESET, Arrays.copyOfRange(s, 1, s.length));
        ChatLib.INSTANCE.chat(text + " " + EnumChatFormatting.GOLD + "(" + convByGoogleIME(toKana(msg)) + EnumChatFormatting.GOLD + ")");
    }

    public void run() {
        if (this.mode.equals("chat")) {
            this.sendChat(this.str);
        }

    }
}
