class Jawna
	def initialize(napis)
		@napis = napis
	end
	def zaszyfruj(k)
		word = String.new(@napis)
		0.upto(word.length){|x| word[x] = k[word[x]] if k.has_key?(word[x])}
		return Zaszyfrowana.new(word)
	end
	def to_s
		@napis
	end
end

class Zaszyfrowana
	def initialize(napis)
		@napis = napis
	end
	def odszyfruj(k)
		word = String.new(@napis)
		k = k.invert
		0.upto(word.length){|x| word[x] = k[word[x]] if k.has_key?(word[x])}
		return Jawna.new(word)
	end
	def to_s
		@napis
	end
end

x = Jawna.new("ruby")
H = { "a" => "b",
  "b" => "r",
  "r" => "y",
  "y" => "u",
  "u" => "a"
}

y = x.zaszyfruj(H)
puts x
puts y
puts y.odszyfruj(H)
