package validstrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test0() {
	    // Input
	    //   aabbcd
	    // Expected Output
	    //   NO
	    // Explanation
	    //   Given s="aabbcd", we would need to remove two characters, both c and d to give "aabb", 
	    //   or remove a and b to give "abcd" to make it valid. We are limited to removing only one 
	    //   character, so s is invalid.
		String s = "aabbcd";
		assertEquals(Solution.isValid(s),"NO");
	}	
	
	@Test
	void test1() {
	    // Input
	    //   aabbccddeefghi
	    // Expected Output
	    //   NO
	    // Explanation
	    //   Frequency counts for the letters are as follows:
	    //   {a:2, b:2, c:2, d:2, e:2, f:1, g:1, h:1, i:1}
	    //   There are two ways to make the valid string:
	    //   - Remove 4 characters with a frequency of 1: {fghi}.
	    //   - Remove 5 characters of frequency 2: {abcde}.
	    //   Neither of these is an option.
		String s = "aabbccddeefghi";
		assertEquals(Solution.isValid(s),"NO");
	}	
	
	@Test
	void test2() {
	    // Input
	    //   abcdefghhgfedecba
	    // Expected Output
	    //   YES
	    // Explanation
	    //   All characters occur twice except for e which occurs 3 times. We can delete one instance 
	    //   of e to have a valid string.
		String s = "abcdefghhgfedecba";
		assertEquals(Solution.isValid(s),"YES");
	}	
	
	@Test
	void test3() {
	    // Input
	    //   aaaabbcc
	    // Expected Output
	    //   NO
	    // Explanation
	    //   char counts: a:4,b:2,c:2
	    //   count frequencies: 1,2
	    //   char count differences: 2,2,0
		String s = "aaaabbcc";
		assertEquals(Solution.isValid(s),"NO");
	}

	@Test
	void test4() {
	    // Input
	    //   aaaaabc
	    // Expected Output
	    //   NO
	    // Explanation
	    //   char counts: 5,1,1
	    //   count frequencies: 2,1
	    //   char count differences: 4,4,0
		String s = "aaaaabc";
		assertEquals(Solution.isValid(s),"NO");
	}

	@Test
	void test5() {
	    // Input
	    //   ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd
	    // Expected Output
	    //   YES
	    // Explanation
	    //   char counts: 111,111,111,111,111,111,111,111,111,1
	    //   count frequencies: 1,9
	    //   char count differences: 0,0,0,0,0,0,0,0,110,0,0,0,0,0,0,0,110,0,0,0,0,0,0,110,0,0,0,0,0,110,0,0,0,0,110,0,0,0,110,0,0,110,0,110,110  
		String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
		assertEquals(Solution.isValid(s),"YES");
	}

}
