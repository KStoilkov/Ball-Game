var n = 5;

var nums = [],
	temp = [];

var indexI = 1, 
	indexJ;

var total = 1;

for (var i = 0; i < n; i++) {
	nums[i] = i + 1;
	temp[i] = i;
};

while(indexI < n) {
	temp[indexI]--;

	if (indexI % 2 === 1) {
		indexJ = temp[indexI];
	} else {
		indexJ = 0;
	}

	Swap(nums[indexI], nums[indexJ]);

	indexI = 1;

	while(temp[indexI] === 0) {
		temp[indexI] = indexI;
		indexI++;
	}

	total++;
}

console.log(total);

function Swap(a, b){
	var t = a;
	a = b;
	b = t;
}


