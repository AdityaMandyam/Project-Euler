import java.math.*;
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		long startTime = System.nanoTime();
		System.out.println(PandigitalProducts());
		long stopTime = System.nanoTime();
		System.out.println("Time taken: " + (double)(stopTime - startTime) / 1000000000 + " seconds");
	}
	// problem 1
	/*
	 * This was a very straightforward problem. I just iterated through all the numbers under 1000
	 * and if they were a multiple of 3 or 5, I added them to the sum. Then return the sum.
	 */
	public static int MultiplesOf3And5(){
		int sum = 0;
		for(int i = 1; i < 1000; i++){
			if(i % 3 == 0 || i % 5 == 0){
				sum += i;
			}
		}
		return sum;
	}
	// problem 2
	/*
	 * For this problem, I initially tried to make an array of fibonacci numbers less than or equal to
	 *  4000000 and then check if each element in that array was even, and if it is, add it to the sum.
	 *  It was a very inefficient method, so I refined it by researching fibonacci numbers. I learned 
	 *  that the golden ratio can be used to calculate the Nth fibonacci number, so I used that information
	 *  to generate a number, and then check if it was under 4000000 and if it was even. If it satisfied
	 *  those conditions, add it to the sum, and the moment the fibonacci number went over 4000000, break
	 *  out of the loop. Then return the sum.
	 */
	public static int EvenFibonacciNumbers(){
		int sum = 0;
		double goldenRatio = 1.6180339887498948420;
		for(int i = 3; i < 1000; i+=3){
			int fibNumber = (int) ((Math.pow(goldenRatio, i) - Math.pow(1-goldenRatio, i)) / Math.sqrt(5));
			if(fibNumber <= 4000000 && fibNumber % 2 == 0){
				sum += fibNumber;
			} else{
				break;
			}
		}
		return sum;
	}
	// problem 3
	/*
	 * For this problem, I found all the factors of the number given, and stored them in a list. Then going
	 * backwards in the factor list, I found the largest prime element in the factor list, and I returned 
	 * that value.
	 */
	public static int LargestPrimeFactor(){
		int primeFactor = 0;
		double number = 600851475143.0;
		ArrayList <Integer> factorList = new ArrayList<>();
		for(int i = 3; i < (int)Math.sqrt(number / 2) + 1; i+=2){
			if(number % i == 0){
				factorList.add(i);
			}
		}
		for(int i = factorList.size() - 1; i >= 0; i--){
			ArrayList<Integer> primeFactorList = new ArrayList<>();
			for(int j = 1; j < (int)Math.sqrt(factorList.get(i)) + 1; j++){
				if(factorList.get(i) % j == 0){
					primeFactorList.add(j);
				}
			}
			if(primeFactorList.size() == 1){
				return factorList.get(i);
			}
		}
		return primeFactor;
	}
	// problem 4
	/*
	 * For this problem, I multiplied all the numbers between 800 and 999 inclusive, and then checked if
	 * the product was a palindrome number. If it was, I added it to a list of possible answers. Then I just 
	 * got the largest element of the possible answers list.
	 */
	public static int LargestPalindromeProduct(){
		int product = 0;
		ArrayList <Integer> possibleAnswers = new ArrayList<>();
		for(int i = 999; i >= 800; i--){
			for(int j = 999; j >= 800; j--){
				int number = i * j;
				int n = number;
				int remainder;
				int reverse = 0;
				while(number > 0){
					remainder = number % 10;
					reverse = reverse * 10 + remainder;
					number = number / 10;
				}
				if(n == reverse){
					possibleAnswers.add(n); 
				}
			}
		}
		for(int x : possibleAnswers){
			if(x > product){
				product = x;
			}
		}
		return product;
	}
	// problem 5
	/*
	 * For this problem, I simply set up a while loop that keeps going until the answer is found.
	 * I didn't know how high I had to go, so I wasn't able to use a for loop. The while loop just 
	 * increments a number i and then checks if it's divisible by all the numbers under 20. The moment 
	 * i is divisible by all positive integers under 20, it returns i, and breaks out of the loop.
	 */
	public static int SmallestMultiple(){
		int i = 1;
		while(1 == 1){
			if(i % 2 == 0 && i % 3 == 0 && i % 4 == 0 && i % 5 == 0 && i % 6 == 0 && i % 7 == 0 && i % 8 == 0 && i % 9 == 0 &&i % 10 == 0 && i % 11 == 0 && i % 12 == 0 && i % 13 == 0 && i % 14 == 0 && i % 15 == 0 && i % 16 == 0 && i % 17 == 0 && i % 18 == 0 && i % 19 == 0 && i % 20 == 0 ){
				return i;
			}
			i++;
		}
	}
	// problem 6
	/*
	 * This problem was also very straightforward. I just computed the sum of squares and the sum of all 
	 * positive integers under 100, and then squared that, and subtracted the sum of squares from it.
	 */
	public static int SumSquareDifference(){
		int sumOfSquares = 0;
		for(int i = 1; i < 101; i++){
			sumOfSquares += (i*i);
		}
		int squareOfSums = 0;
		for(int i = 1; i < 101; i++){
			squareOfSums += i;
		}
		return (squareOfSums * squareOfSums) - sumOfSquares;
	}
	// problem 7
	/*
	 * For this problem, I created an empty list, and while it was less than 10001 elements long, 
	 * I kept adding primes to it. Then, I got the last element from it.
	 */
	public static int TenThousandFirstPrime(){
		ArrayList <Integer> primesList = new ArrayList<>();
		int number = 1;
		while(primesList.size() <= 10001){
			ArrayList <Integer> factorList = new ArrayList<>();
			for(int i = 1; i <= Math.sqrt(number) + 1; i++){
				if(number % i == 0){
					factorList.add(i);
				}
			}
			if(factorList.size() == 1){
				primesList.add(number);
			}
			number++;
		}
		return primesList.get(10000);
		
	}
	// problem 8
	/*
	 * For this problem, I stored the 1000 digit number as a string, and then just walked through it in
	 * groups of 13, 1 digit at a time. I stored all the possible answers in a list, and then just got
	 * the largest one. In order to save time during computations, every time there was a 0 in the group
	 * of 13, I just skipped it. 
	 */
	public static double LargestProductInASeries(){
		String numberSeries = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		ArrayList <Double> possibleAnswers = new ArrayList<>();
		int startIndex = 0;
		int endIndex = 13;
		while(endIndex <= numberSeries.length()){
			String subString = numberSeries.substring(startIndex, endIndex);
			startIndex++;
			endIndex++;
			if(subString.contains("0")){
				continue;
			}
			double sum = 1;
			for(int i = 0; i < subString.length(); i++){
				sum *= (Character.getNumericValue(subString.charAt(i)));
			}
			possibleAnswers.add(sum);
		}
		Collections.sort(possibleAnswers);
		return (possibleAnswers.get(possibleAnswers.size() - 1));
	}
	// problem 9
	/*
	 * This problem was also a straightforward one. For all integers a and b under 1000, I calculated
	 * c. Then I checked if a + b + c was equal to 1000. If it was, I just returned the product of all 
	 * three.
	 */
	public static String SpecialPythagoreanTriplet(){
		for(int a = 1; a < 1000; a++){
			for(int b = 1; b < 1000; b++){
				double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
				if((a + b + c) == 1000){
					return String.format("%.0f", a * b * c);
				}
			}
		}
		return "";
	}
	// problem 10 - NEEDS TO BE FASTER
	/*
	 * I used the same method of getting primes as I did in problem 7. This time, I just kept finding primes
	 * that were less than 2000000, and then stored them all in a list. Then I just added all the elements
	 * of the list. To save time on computations, I only checked odd numbers, since the only even prime
	 * number is 2. 
	 */
	public static double SummationOfPrimes(){
		double number = 3;
		ArrayList <Double> primesList = new ArrayList<>();
		while(number <= 2000000){
			int factorCount = 0;
			for(int i = 1; i < (int)Math.sqrt(number) + 1; i++){
				if(number % i == 0){
					factorCount++;
				}
			}
			if(factorCount == 1){
				primesList.add(number);
			}
			number+=2;
		}
		double sum = 2;
		for(double x : primesList){
			sum += x;
		}
		return sum;
	}
	// problem 11
	/*
	 * Since there was no special mathematical property I could use for this problem, I stored the grid 
	 * as a 2D array, and then calculated all the possible answers. The problem asked what the greatest
	 * product was in the same direction, and since multiplication is commutative, I only needed to check 
	 * most of the directions specified (Right, Down, and Diagonal both ways).
	 */
	public static int LargestProductInAGrid(){
		int grid[][] = {{8, 2, 22, 97, 38, 15, 00, 40, 00, 75, 04, 05, 07, 78, 52, 12, 50, 77, 91, 8}, 
		                {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0},
		                {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65},
		                {52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 2, 36, 91},
		                {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
		                {24, 47, 32, 60, 99, 3, 45, 02, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
		                {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
		                {67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
		                {24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
		                {21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
		                {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 04, 62, 16, 14, 9, 53, 56, 92},
		                {16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57},
		                {86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
		                {19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40},
		                {4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
		                {88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
		                {4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
		                {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},
		                {20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},
		                {1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48}};
		
		int largestProduct = 0;
		for(int x[] : grid){
			for(int i = 0; i < 17; i++){
				largestProduct = Math.max(largestProduct, (x[i] * x[i+1] * x[i+2] * x[i+3]));
			}
		}
		for(int i = 0; i < 17; i++){
			for(int j = 0; j < 20; j++){
				largestProduct = Math.max(largestProduct, grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j]);
			}
		}
		for(int i = 0; i < 17; i++){
			for(int j = 0; j < 17; j++){
				largestProduct = Math.max(largestProduct, grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3]);			}
		}
		for(int i = 0; i < 17; i++){
			for(int j = 19; j > 3; j--){
				largestProduct = Math.max(largestProduct, grid[i][j] * grid[i+1][j-1] * grid[i+2][j-2] * grid[i+3][j-3]);			}
		}
		return largestProduct;
	}
	// problem 12
	/*
	 * For this problem, I generated triangle numbers in an infinite loop, and then checked how many
	 * factors the generated number had. I added 2 factors every time I found a factor less than the 
	 * square root of the number, and took one factor out if it was a perfect square. This allowed me
	 * to minimize the number of iterations I had to go through when I was finding factors. The infinite 
	 * loop ends when I find and return the answer.
	 */
	public static long HighlyDivisibleTriangularNumber(){
		long triangleNumber = 0;
		int i = 1;
		while(1 == 1){
			int factorCount = 0;
			triangleNumber += i;
			for(int j = 1; j <= Math.ceil(Math.sqrt(triangleNumber)); j++){
				if(triangleNumber % j == 0){
					factorCount+=2;
				}
				if(triangleNumber == j*j){
					factorCount--;
				}
			}
			if(factorCount > 500){
				return triangleNumber;
			}
			i++;
		}
	}
	// problem 13
	/*
	 * This problem looked complex, but became very simple once you stored the numbers as doubles instead
	 * of integers. Since the problem was asking for the first 10 digits of the sum, all I needed to do
	 * was divide each number by 1*10^49. Then, each number became a small decimal number whose extreme 
	 * precision did not matter. That is also why I used doubles instead of floating point numbers.
	 * As long as the first 11 digits were precisely stored, I can find the answer to the problem. Once 
	 * I confirmed that, I just added up the elements in the array used to store the numbers, and then
	 * formatted it to show me the first 10 digits. 
	 */
	public static String LargeSum(){
		double numbers[] = {
				3.7107287533902102798797998220837590246510135740250,
				4.6376937677490009712648124896970078050417018260538,
				7.4324986199524741059474233309513058123726617309629,
				9.1942213363574161572522430563301811072406154908250,
				2.3067588207539346171171980310421047513778063246676,
				8.9261670696623633820136378418383684178734361726757,
				2.8112879812849979408065481931592621691275889832738,
				4.4274228917432520321923589422876796487670272189318,
				4.7451445736001306439091167216856844588711603153276,
				7.0386486105843025439939619828917593665686757934951,
				6.2176457141856560629502157223196586755079324193331,
				6.4906352462741904929101432445813822663347944758178,
				9.2575867718337217661963751590579239728245598838407,
				5.8203565325359399008402633568948830189458628227828,
				8.0181199384826282014278194139940567587151170094390,
				3.5398664372827112653829987240784473053190104293586,
				8.6515506006295864861532075273371959191420517255829,
				7.1693888707715466499115593487603532921714970056938,
				5.4370070576826684624621495650076471787294438377604,
				5.3282654108756828443191190634694037855217779295145,
				3.6123272525000296071075082563815656710885258350721,
				4.5876576172410976447339110607218265236877223636045,
				1.7423706905851860660448207621209813287860733969412,
				8.1142660418086830619328460811191061556940512689692,
				5.1934325451728388641918047049293215058642563049483,
				6.2467221648435076201727918039944693004732956340691,
				1.5732444386908125794514089057706229429197107928209,
				5.5037687525678773091862540744969844508330393682126,
				1.8336384825330154686196124348767681297534375946515,
				8.0386287592878490201521685554828717201219257766954,
				7.8182833757993103614740356856449095527097864797581,
				1.6726320100436897842553539920931837441497806860984,
				4.8403098129077791799088218795327364475675590848030,
				8.7086987551392711854517078544161852424320693150332,
				5.9959406895756536782107074926966537676326235447210,
				6.9793950679652694742597709739166693763042633987085,
				4.1052684708299085211399427365734116182760315001271,
				6.5378607361501080857009149939512557028198746004375,
				3.5829035317434717326932123578154982629742552737307,
				9.4953759765105305946966067683156574377167401875275,
				8.8902802571733229619176668713819931811048770190271,
				2.5267680276078003013678680992525463401061632866526,
				3.6270218540497705585629946580636237993140746255962,
				2.4074486908231174977792365466257246923322810917141,
				9.1430288197103288597806669760892938638285025333403,
				3.4413065578016127815921815005561868836468420090470,
				2.3053081172816430487623791969842487255036638784583,
				1.1487696932154902810424020138335124462181441773470,
				6.3783299490636259666498587618221225225512486764533,
				6.7720186971698544312419572409913959008952310058822,
				9.5548255300263520781532296796249481641953868218774,
				7.6085327132285723110424803456124867697064507995236,
				3.7774242535411291684276865538926205024910326572967,
				2.3701913275725675285653248258265463092207058596522,
				2.9798860272258331913126375147341994889534765745501,
				1.8495701454879288984856827726077713721403798879715,
				3.8298203783031473527721580348144513491373226651381,
				3.4829543829199918180278916522431027392251122869539,
				4.0957953066405232632538044100059654939159879593635,
				2.9746152185502371307642255121183693803580388584903,
				4.1698116222072977186158236678424689157993532961922,
				6.2467957194401269043877107275048102390895523597457,
				2.3189706772547915061505504953922979530901129967519,
				8.6188088225875314529584099251203829009407770775672,
				1.1306739708304724483816533873502340845647058077308,
				8.2959174767140363198008187129011875491310547126581,
				9.7623331044818386269515456334926366572897563400500,
				4.2846280183517070527831839425882145521227251250327,
				5.5121603546981200581762165212827652751691296897789,
				3.2238195734329339946437501907836945765883352399886,
				7.5506164965184775180738168837861091527357929701337,
				6.2177842752192623401942399639168044983993173312731,
				3.2924185707147349566916674687634660915035914677504,
				9.9518671430235219628894890102423325116913619626622,
				7.3267460800591547471830798392868535206946944540724,
				7.6841822524674417161514036427982273348055556214818,
				9.7142617910342598647204516893989422179826088076852,
				8.7783646182799346313767754307809363333018982642090,
				1.0848802521674670883215120185883543223812876952786,
				7.1329612474782464538636993009049310363619763878039,
				6.2184073572399794223406235393808339651327408011116,
				6.6627891981488087797941876876144230030984490851411,
				6.0661826293682836764744779239180335110989069790714,
				8.5786944089552990653640447425576083659976645795096,
				6.6024396409905389607120198219976047599490197230297,
				6.4913982680032973156037120041377903785566085089252,
				1.6730939319872750275468906903707539413042652315011,
				9.4809377245048795150954100921645863754710598436791,
				7.8639167021187492431995700641917969777599028300699,
				1.5368713711936614952811305876380278410754449733078,
				4.0789923115535562561142322423255033685442488917353,
				4.4889911501440648020369068063960672322193204149535,
				4.1503128880339536053299340368006977710650566631954,
				8.1234880673210146739058568557934581403627822703280,
				8.2616570773948327592232845941706525094512325230608,
				2.2918802058777319719839450180888072429661980811197,
				7.7158542502016545090413245809786882778948721859617,
				7.2107838435069186155435662884062257473692284509516,
				2.0849603980134001723930671666823555245252804609722,
				5.3503534226472524250874054075591789781264330331690,
		};
		double finalSum = 0;
		for(double x : numbers){
			finalSum += x;
		}
		return String.format("%.7f", finalSum);
	}
	// problem 14 - NEEDS TO BE FASTER
	/*
	 * Very simple direct approach. Just iterating through all numbers below 1000000, and counting the 
	 * length of each sequence and then returning the greatest length.
	 */
	public static long LongestCollatzSequence(){
		long startNumber = 0;
		long length = 0;
		long j;
		for(int i = 2; i <= 1000000; i++){
			j = i;
			int sequenceLength = 1;
			while(j != 1){
				if(j % 2 == 0){
					j = j / 2;
				} else{
					j = (3*j) + 1;
				}
				sequenceLength++;
			}
			if(length < sequenceLength){
				length = sequenceLength;
				startNumber = i;
			}
		}
		return startNumber;	
	}
	// problem 15
	/*
	 * I realized that this was a combinatorics problem the moment I read it, but the question was what 
	 * I should calculate. I knew that I needed combinations and not permutations since the order of the 
	 * paths did not matter, so I looked at the example given in the problem and noticed that 2n C n,
	 * where n is one of the dimensions of the square grid yielded the result they gave in the example.
	 * I then just did the same thing with n = 20. 
	 */
	public static String LatticePaths(){
		int n = 20;
		double nFactorial = 1;
		double kFactorial = 1;
		for(int i = 1; i <= 2*n; i++){
			nFactorial *= i;
			if(i <= 20){
				kFactorial *= i;
			}
		}
		double answer = nFactorial / Math.pow(kFactorial, 2);
		return String.format("%.0f", answer);
	}
	// problem 16
	/*
	 * The main issue for this problem is the memory limitations of primitive types in Java. 
	 * The maximum number that an int type can hold is 2147483647, while 2^1000 is much more than that.
	 * The maximum number held by a long type is 9.223372037E18, while 2^1000 is much more than that.
	 * Therefore, I needed to use the BigDecimal class from the Math Package to store my number. Once 
	 * I could store the number, the rest was easy. I used the toString method to store it as a string,
	 * then converted each character of the string to a digit, and then added it to a running total.
	 */
	public static int PowerDigitSum(){
		BigDecimal number = new BigDecimal(Math.pow(2, 1000));
		String numberString =  number.toString();
		int sum = 0;
		for(int i = 0; i < numberString.length(); i++){
			sum += Character.getNumericValue(numberString.charAt(i));
		}
		return sum;
	}
	// problem 18
	// Incomplete
	public static double MaximumPathSumI(){
		double grid[][] = {
				{75},
				{95, 64},
				{17,47,82},
				{18, 35, 87, 10},
				{20, 4, 82, 47, 65},
				{19, 1, 23, 75, 3, 34},
				{88, 2, 77, 73, 7, 63, 67},
				{99, 65, 4, 28, 6, 16, 70, 92},
				{41, 41, 26, 56, 83, 40, 80, 70, 33},
				{41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
				{53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
				{70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
				{91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
				{63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
				{04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
		};
		int sum = 75;
		int i = grid.length - 1;
		double maxInitial = 0;
		for(double x : grid[i]){
			if(x > maxInitial){
				maxInitial = x;
			}
		}
		//int maxInitialIndex = 0;
		while(i > 0){
			//int index = 0;
			
		}
		return sum;
		
	}
	// problem 19
	/*
	 * This problem was fun to do. I decided not to use brute force with the GregorianCalendar class.
	 * I found out that January 1st 1901 was a Tuesday, and then used that information to calculate 
	 * the first day of each month following it, until 2000. I found out that the first day can be
	 * found by adding the remainder of the number of days in the month divided by 7 to the index of
	 * what I found (Tuesday). If the value was greater than 7, I just subtracted the value I found from
	 * 7 and made it positive if necessary just to be able to access the index of the daysOfWeek array.
	 * Then I added all the calculated "first days" to an ArrayList, and then just counted the number or
	 * "Sunday"'s in the list.
	 */
	public static double CountingSundays(){
		String daysOfWeek[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int sundayCounter = 0;
		int year = 1901;
		int firstDay = 3;
		HashMap<String, Integer> monthDayCounts = new HashMap<String, Integer>();
		monthDayCounts.put("January", 31);
		monthDayCounts.put("February", 28);
		monthDayCounts.put("March", 31);
		monthDayCounts.put("April", 30);
		monthDayCounts.put("May", 31);
		monthDayCounts.put("June", 30);
		monthDayCounts.put("July", 31);
		monthDayCounts.put("August", 31);
		monthDayCounts.put("September", 30);
		monthDayCounts.put("October", 31);
		monthDayCounts.put("November", 30);
		monthDayCounts.put("December", 31);
		ArrayList<String> firstDayNames= new ArrayList<>();
		while(year < 2001){
			for(String key : monthDayCounts.keySet()){
				if(year % 4 != 0){
					monthDayCounts.replace("February", 28);
					if(firstDay + monthDayCounts.get(key) % 7 < 7){
						firstDay += monthDayCounts.get(key) %  7;
						firstDayNames.add(daysOfWeek[firstDay]);
					} else{
						firstDay = 7 - (firstDay + monthDayCounts.get(key) % 7);
						firstDay = firstDay < 0 ? -firstDay : firstDay;
						firstDayNames.add(daysOfWeek[firstDay]);
					}
				} else{
					monthDayCounts.replace("February", 29);
					if(firstDay + monthDayCounts.get(key) % 7 < 7){
						firstDay += monthDayCounts.get(key) %  7;
						firstDayNames.add(daysOfWeek[firstDay]);
					} else{
						firstDay = 7 - (firstDay + monthDayCounts.get(key) % 7);
						firstDay = firstDay < 0 ? -firstDay : firstDay;
						firstDayNames.add(daysOfWeek[firstDay]);
					}
				}
			}
			year++;
		}
		for(String x : firstDayNames){
			if(x.equals("Sunday")){
				sundayCounter++;
			}
		}
		return sundayCounter;
	}
	// problem 20
	/*
	 * For this problem, I used the same approach as problem 16, the Power Digit Sum. I used BigDecimal
	 * to store the calculated value of 100!, and then I got the string representation of the object
	 * using the toString() method, and then I just iterated through all the characters in the string,
	 * got their numeric value with the getNumericValue of the Character class, and then added it to a
	 * running total.
	 */
	public static double FactorialDigitSum(){
		BigDecimal number = new BigDecimal(1);
		for(int i = 1; i <= 100; i++){
			number = number.multiply(new BigDecimal(i));
		}
		String numberString = number.toString();
		double total = 0;
		for(int i = 0; i < numberString.length(); i++){
			total += Character.getNumericValue(numberString.charAt(i));
		}
		return total;
	}
	// problem 21
	/*
	 * For this problem, I iterated through all the numbers under 10001, found the sum of the factors 
	 * of each, and then I just checked if there was a corresponding number that made an amicable number
	 * pair. If there was, then I added it to a running total. I also checked to see if the sum of
	 * proper divisors was less than the number itself, so that I wouldn't double-count amicable
	 * numbers.
	 */
	public static double AmicableNumbers(){
		double numberCount = 0;
		for(int i = 2; i < 10001; i++){
			int A = 0;
			for(int k = 1; k < Math.ceil(i / 2) + 1; k++){
				if(i % k == 0){
					A += k;
				}
			}
			int B = 0;
			for(int k = 1; k < Math.ceil(A / 2) + 1; k++){
				if(A % k == 0){
					B += k;
				}
			}
			if(A < i && B == i){
				numberCount += (i + A);
			}
		}
		return numberCount;
	}
	// problem 22
	/*
	 * For this problem, I used a Scanner to read the names into an array. The names were comma
	 * separated so I used the String.split method to separate the names. I used the Collections.sort
	 * method to alphabetize the names. Then I made a String containing the alphabet in order, and 
	 * then used the indexes of the characters in that string to calculate the number score. After
	 * that, I multiplied the number score by it's position in the sorted name list to get the final
	 * number score, and then added them to a running total.
	 */
	public static int NamesScores() throws FileNotFoundException{
		Scanner input = new Scanner(new File("names.txt"));
		List<String> names = new ArrayList<String>(Arrays.asList(input.next().split(",")));
		input.close();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Collections.sort(names);
		int sum = 0;
		for(String x : names){
			int nameScore = 0;
			for(int i = 0; i < x.length(); i++){
				nameScore += alphabet.indexOf(x.charAt(i)) + 1;
			}
			sum += (nameScore * (names.indexOf(x) + 1));
		}
		return sum;
	}
	// problem 23 - NEEDS TO BE FASTER
	/*
	 * For this problem, I had issues with keeping the execution time low. Finding abundant numbers was 
	 * very easy since I just found the factors of the number 
	 */
	public static int NonAbundantSums(){
		ArrayList<Integer> abundantNumbers = new ArrayList<>();
		for(int i = 12; i <= 28123; i++){
			int sum = 0;
			for(int j = 1; j < Math.ceil(i / 2) + 1; j++){
				if(i % j == 0){
					sum += j;
				}
			}
			if(sum > i){
				abundantNumbers.add(i);
			}
		}
		boolean sumOfAbundantNumbers[] = new boolean[28124];
		for(int x : abundantNumbers){
			for(int j : abundantNumbers){
				if((x + j) <= 28123){
					sumOfAbundantNumbers[x + j] = true;
				} else{
					break;
				}
			}
		}
		for(boolean x : sumOfAbundantNumbers){
			if(x){
				continue;
			} else{
				x = false;
			}
		}
		int sum = 0;
		for(int i = 0; i < sumOfAbundantNumbers.length; i++){
			if(!sumOfAbundantNumbers[i]){
				sum += i;
			}
		}
		return sum;
	}
	// problem 24
	/*
	 * For this problem, I searched the Internet for algorithms that produce permutations of the 
	 * characters. I found a website where the author referenced a book called "A Discipline of Programming"
	 * by E. W. Dijkstra. The author of the website had listed an algorithm that would produce permutations
	 * in lexicographic order. I implemented the algorithm, and placed it in a loop that would end once it
	 * found the millionth permutation.
	 */
	public static String LexicographicPermutations(){
		int counter = 0;
		char numbers[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		while(counter < 999999){
			int N = numbers.length;
			int i = N - 1;
			while(numbers[i - 1] >= numbers[i]){
				i = i - 1;
			}
			int j = N;
			while(numbers[j - 1] <= numbers[i - 1]){
				j = j - 1;
			}
			char temp1 = numbers[j - 1];
			numbers[j - 1] = numbers[i - 1];
			numbers[i - 1] = temp1;
			i++;
			j = N;
			while(i < j){
				char temp2 = numbers[j - 1];
				numbers[j - 1] = numbers[i - 1];
				numbers[i - 1] = temp2;
				i++;
				j--;
			}
			counter++;
		}
		String x = "";
		for(char y : numbers){
			x += y;
		}
		return x;
	}
	// problem 25
	/* 
	 * I solved this problem by simply calculating fibonacci numbers until I found one that is 1000 characters
	 * long. I created an array of length 3 of BigIntegers. At index 0, I stored the 1st fibonacci number.
	 * At index 1, I stored the 2nd fibonacci number. At index 2, I stored the 0th fibonacci number. I set
	 * my index counter to 0, and then just calculated fibonacci numbers until I got a 1000 length number.
	 * Then I returned the index counter that was incrementing each time a number was found. I could 
	 * not use my previous method of finding fibonacci numbers using the golden ratio since the power 
	 * method in the BigDecimal class only takes integer parameters. I only needed to store the previous
	 * 2 fibonacci numbers since those are necessary to calculate the next number. 
	 */
	public static int ThousandDigitFibonacciNumber(){
		String fibString = "";
		BigInteger first = new BigInteger("0");
		BigInteger second = new BigInteger("1");
		BigInteger third = new BigInteger("1");
		BigInteger[] fibNumbers = {first, second, third};
		int i = 0;
		int counter = 2;
		while(fibString.length() < 1000){
			if(counter == 3){
				fibNumbers[1] = fibNumbers[0].add(fibNumbers[2]);
				counter = 1;
			} else if (counter == 2){
				fibNumbers[0] = fibNumbers[2].add(fibNumbers[1]);
				counter++;
			} else if (counter == 1){
				fibNumbers[2] = fibNumbers[0].add(fibNumbers[1]);
				counter++;
			}
			i++;
			fibString = fibNumbers[2].toString();
		}
		return i;
	}
	// problem 26
	// Incomplete
	public static double ReciprocalCycles(){
		HashMap<Integer, Boolean> values = new HashMap<Integer, Boolean>();
		for(int i = 2; i <= 1000; i++){
			values.put(i, true);
		}
		for(int i = 2; i < Math.ceil(Math.sqrt(1000)) + 1; i++){
			if(values.get(i) == true){
				for(double j = Math.pow(i, 2); j <= 1000; j += i){
					values.replace((int)j, false);
				}
			}
		}
		ArrayList<Integer> primes = new ArrayList<>();
		for(int key : values.keySet()){
			if(values.get(key) == true){
				primes.add(key);
			}
		}
		return 0;
	}
	// problem 28
	/*
	 * This problem was a fun little trick question. If you look at the diagram they provided, you'll
	 * notice that the number in the top left corner could be defined by (3n + 1)^2, or the square of
	 * consecutive odd numbers. Then the other three numbers to add can be found out by subtracting 
	 * n and then adding 1. Now that we have found all the numbers on the diagonal, we just need
	 * to add them all together, which can be done by adding each diagonal for each loop in the spiral
	 * to a running total. I returned a formatted string because Java represents large double values
	 * in scientific notation. I used the string only for aesthetics.
	 */
	public static String NumberSpiralDiagonals(){
		double i = 3;
		double x = 0;
		double sum = 1;
		while(x < Math.pow(1001, 2)){
			x = i * i;
			double add1 = (x - i) + 1 > 0 ? (x - i) + 1 : 0;
			double add2 = (add1 - i) + 1 > 0 ? (add1 - i) + 1 : 0;
			double add3 = (add2 - i) + 1 > 0 ? (add2 - i) + 1 : 0;
			sum += x + add1 + add2 + add3;
			i += 2;
		}
		return String.format("%.0f", sum);
	}
	// problem 29
	/*
	 * This problem was fairly straightforward. I used the BigInteger class to store the value of 
	 * a^b, since it got very large towards the end (100^100). I added these values to an ArrayList
	 * Then, I removed all the duplicates by converting the ArrayList to a HashSet, and found the size
	 * of the HashSet.
	 */
	public static int DistinctPowers(){
		ArrayList<BigInteger> numbers= new ArrayList<>();
		for(int i = 2; i <= 100; i++){
			for(int j = 2; j <= 100; j++){
				BigInteger number = new BigInteger(i + "").pow(j);
				numbers.add(number);
			}
		}
		HashSet<BigInteger> removeDuplicates = new HashSet<>(numbers);
		return removeDuplicates.size();
	}
	// problem 30
	/*
	 * For this problem, I ran through all the numbers under 295245 and then just added up the ones that
	 * satisfied the conditions. I converted the number to a string to be able to access the individual
	 * digits and then took the digits to the fifth power and added them to the sum. If the sum was equal
	 * to the number, then I added it to a running total. I took 295245 as the upper bound because it was 
	 * the largest sum that you can make using the premise of the problem (9^5 + 9^5 + 9^5 + 9^5 + 9^5).
	 */
	public static int DigitFifthPowers(){
		int answer = 0;
		for(int i = 2; i < 295245; i++){
			int sum = 0;
			String x = i + "";
			for(int j = 0; j < x.length(); j++){
				sum += Math.pow(Character.getNumericValue(x.charAt(j)), 5);
			}
			if(sum == i){
				answer += i;
			}
		}
		return answer;
	}
	//problem 32
	public static int PandigitalProducts(){
		ArrayList<Integer> pandigitals = new ArrayList<>();
		ArrayList<Character> compareTo = new ArrayList<>();
		compareTo.add('1');
		compareTo.add('2');
		compareTo.add('3');
		compareTo.add('4');
		compareTo.add('5');
		compareTo.add('6');
		compareTo.add('7');
		compareTo.add('8');
		compareTo.add('9');
		for(int i = 1234; i <= 9876; i++){
			for(int j = 1; j < Math.ceil(Math.sqrt(i)) + 1; j++){
				for(int k = 1; k < Math.ceil(Math.sqrt(i)) + 1; k++){
					ArrayList<Character> toCompare = new ArrayList<>();
					String x = i + "" + j + "" + k + "";
					for(int a = 0; a < x.length(); a++){
						toCompare.add(x.charAt(a));
					}
					Collections.sort(toCompare);
					boolean isSame = true;
					if(toCompare.size() == compareTo.size()){
						for(int b = 0; b < compareTo.size(); b++){
							if(toCompare.get(b) != compareTo.get(b)){
								isSame = false;
							}
						}
					}
					if(isSame){
						System.out.println(j + " x " + k + " = " + i);
						pandigitals.add(i);
					}
				}
			}
		}
		HashSet<Integer> removeDuplicates = new HashSet<>(pandigitals);
		int sum = 0;
		for(int x : removeDuplicates){
			sum += x;
		}
		return sum;
	}
}