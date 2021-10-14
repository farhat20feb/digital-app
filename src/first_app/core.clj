(def buyerAccount (ref 100))
(def merchantAccount (ref 0))
(def prices{:pen 10,:book 20,:bottle 30})
(def items (ref[]))

(defn printinfo
[]
(println "Buyer Account: " @buyerAccount)
(println "merchant Account: "@merchantAccount)
(println "items purchased: "@items)
)

(defn buy
[item]
(def itemprice(get prices item))
(if(<= itemprice @buyerAccount)
(dosync
(ref-set merchantAccount(+ @merchantAccount itemprice))
(ref-set buyerAccount(- @buyerAccount itemprice))
(def newitem (cons item @items))
(ref-set items newitem)
(printinfo))
(println "Insufficiant Fund:"))
)

