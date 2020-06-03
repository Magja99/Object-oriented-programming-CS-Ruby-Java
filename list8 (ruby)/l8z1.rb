class Fixnum
	def czynniki
		tab = []
		1.upto(self){|x|
			tab << x if self % x == 0}
		return tab
	end
	def ack(m)
		return m+1 if self == 0
		return (self-1).ack(1) if m == 0
		return (self-1).ack(self.ack(m-1))
	end
	def doskonala
		sum_of_divisors = 1
		2.upto(self - 1){|x|
			sum_of_divisors += x if self % x == 0}
		return sum_of_divisors == self
	end
	def slownie
		cyfry = ["zero","jeden","dwa","trzy","cztery","pięć","sześć","siedem","osiem","dziewięć"]
		return cyfry[self] if self < 10
		return (self/10).floor.slownie + " " + cyfry[self%10]
	end
end

puts 6.czynniki.to_s
puts 321.czynniki.to_s
puts 1024.czynniki.to_s

puts 2.ack(1)
puts 3.ack(2)

puts 28.doskonala
puts 17.doskonala
puts 6.doskonala
puts 321.doskonala

puts 0.slownie
puts 123.slownie
puts 8102.slownie